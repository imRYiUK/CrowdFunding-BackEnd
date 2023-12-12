package com.imryuik.crowdfunding.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class TokenValidationFilter extends OncePerRequestFilter {
    @Value("${authentication.server.url}")
    private String authenticationServerUrl;
    private static final List<String> EXCLUDED_URL_PREFIXES = List.of("/project/public");

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println(request);
        String token = extractTokenFromRequest(request);
        if (request.getHeader("Authorization") == null){
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            if (token != null && validateToken(token)) {
                System.out.println(token);
                filterChain.doFilter(request, response);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            }
        }
    }

    private boolean validateToken(String token) {
        String validationUrl = authenticationServerUrl + "/verify";

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode auth = objectMapper.createObjectNode();
        auth.put("token", token.split(" ")[1]);
        HttpEntity<String> requestEntity = new HttpEntity<>(auth.toString(), header);

        System.out.println(token);

        try {
            ResponseEntity<Boolean> responseEntity = restTemplate.exchange(validationUrl, HttpMethod.POST, requestEntity, Boolean.class);

            return responseEntity.getStatusCode() == HttpStatus.OK;
        } catch (Exception e) {

            return false;
        }

    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames != null) {
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                if ("Authorization".equalsIgnoreCase(headerName)) {
                    System.out.println(headerName);
                    return request.getHeader(headerName);
                }
            }
        }

        return null;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        // Specify conditions under which the filter should not be applied
        String path = request.getServletPath();
        return EXCLUDED_URL_PREFIXES.stream().anyMatch(path::startsWith);
    }
}
