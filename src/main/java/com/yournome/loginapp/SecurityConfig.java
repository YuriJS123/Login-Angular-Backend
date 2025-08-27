package com.yournome.loginapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // desabilita CSRF
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll() // libera seu endpoint
                .anyRequest().authenticated() // o resto precisa estar autenticado
            )
            .httpBasic(httpBasic -> httpBasic.disable()) // desabilita Basic Auth
            .formLogin(form -> form.disable()); // desabilita form login

        return http.build();
    }
}
