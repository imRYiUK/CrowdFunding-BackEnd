package com.imryuik.crowdfunding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class CrowdFundingApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrowdFundingApplication.class, args);
    }

}
