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

    private static final List<String> EXCLUDED_URL_PREFIXES = List.of("/public/");
    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getHeader("authorization") == null) {
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, PATCH, HEAD");
            response.addHeader("Access-Control-Allow-Headers", "*");
            response.addHeader("Access-Control-Allow-Credentials", "true");
            response.addIntHeader("Access-Control-Max-Age", 10);
            response.setStatus(HttpServletResponse.SC_NO_CONTENT);
        } else {
            String token = extractTokenFromRequest(request);
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

//        System.out.println(token);

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
//                System.out.println(headerName);
                if ("Authorization".equalsIgnoreCase(headerName)) {
                    return request.getHeader(headerName);
                }
            }
        }

        return null;
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
        String path = request.getServletPath();
        return EXCLUDED_URL_PREFIXES.stream().anyMatch(path::startsWith);
    }
}
