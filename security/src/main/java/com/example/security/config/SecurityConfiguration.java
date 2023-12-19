package com.example.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.example.security.user.Permission.*;
import static com.example.security.user.Role.ADMIN;
import static com.example.security.user.Role.MANAGER;
import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration  {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf()
                .disable()
                .cors()
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/api/auth/**")
                .permitAll()

                .requestMatchers("api/management/**").hasAnyRole(ADMIN.name(), MANAGER.name())// qikjo u shtu e re


                .requestMatchers(GET,"api/management/**").hasAnyAuthority(ADMIN_READ.name(),MANAGER_READ.name())
                .requestMatchers(POST,"api/management/**").hasAnyAuthority(ADMIN_CREATE.name(),MANAGER_CREATE.name())
                .requestMatchers(PUT,"api/management/**").hasAnyAuthority(ADMIN_UPDATE.name(),MANAGER_UPDATE.name())
                .requestMatchers(DELETE,"api/management/**").hasAnyAuthority(ADMIN_DELETE.name(),MANAGER_DELETE.name())// deri qitu jon shty

                .requestMatchers("api/admin/**").hasRole(ADMIN.name())// qikjo u shtu e re


                .requestMatchers(GET,"api/admin/**").hasAuthority(ADMIN_READ.name())
                .requestMatchers(POST,"api/admin/**").hasAuthority(ADMIN_CREATE.name())
                .requestMatchers(PUT,"api/admin/**").hasAuthority(ADMIN_UPDATE.name())
                .requestMatchers(DELETE,"api/admin/**").hasAuthority(ADMIN_DELETE.name())// deri qitu jon shty

//qito po i shtoj une
                .requestMatchers("api/**").hasRole(ADMIN.name())// qikjo u shtu e re
                .requestMatchers(GET,"api/properties/**").hasAuthority(ADMIN_READ.name())
                .requestMatchers(GET,"api/properties/{propertyId}/**").hasAuthority(ADMIN_READ.name())
                .requestMatchers(POST,"api/properties/**").hasAuthority(ADMIN_CREATE.name())
                .requestMatchers(PUT,"api/properties/{propertyId}**").hasAuthority(ADMIN_UPDATE.name())
                .requestMatchers(DELETE,"api/properties/{propertyId}**").hasAuthority(ADMIN_DELETE.name())// deri qitu jon shty
                .requestMatchers(PATCH,"api/properties/{propertyId}/agent/{agentId}").hasAuthority(ADMIN_PATCH.name())

                .requestMatchers("api/**").hasRole(ADMIN.name())// qikjo u shtu e re
                .requestMatchers(GET,"api/agents/**").hasAuthority(ADMIN_READ.name())
                .requestMatchers(GET,"api/agents/{agentId}/**").hasAuthority(ADMIN_READ.name())
                .requestMatchers(POST,"api/agents/**").hasAuthority(ADMIN_CREATE.name())
                .requestMatchers(PUT,"api/agents/{agentId}**").hasAuthority(ADMIN_UPDATE.name())
                .requestMatchers(DELETE,"api/agents/{agentId}**").hasAuthority(ADMIN_DELETE.name())// deri qitu jon shty






                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/api/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler(((request, response, authentication) ->
                        SecurityContextHolder.clearContext()));




        return http.build();
    }
}
