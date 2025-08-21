package com.chatapplication.chatapplication.security.internals;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    private final CustomCorsConfiguration customCorsConfiguration;
    private final JwtAuthConverter converter;

    public SecurityConfig(CustomCorsConfiguration customCorsConfiguration, JwtAuthConverter converter) {
        this.customCorsConfiguration = customCorsConfiguration;
        this.converter = converter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(authorize -> authorize
                        // .anyRequest().authenticated()
                        .anyRequest().permitAll()

                ).cors(c -> c.configurationSource(customCorsConfiguration))
                .oauth2ResourceServer((oauth2) -> oauth2.jwt(jwtConfigurer ->
                        jwtConfigurer.jwtAuthenticationConverter(converter)
                ))
                .build();

    }
}
