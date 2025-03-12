package com.carportal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http
    ) throws Exception {
        http.csrf().disable().cors().disable();
        //haap
        //http.authorizeHttpRequests().anyRequest().permitAll();

        http.authorizeHttpRequests().requestMatchers("/api/v1/auth/login","/api/v1/auth/sign-up")
                .permitAll()
                 .anyRequest().authenticated();
        return http.build();
    }
}
