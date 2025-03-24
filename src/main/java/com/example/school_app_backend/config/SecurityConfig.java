package com.example.school_app_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails child = User.withUsername("childUser")
                .password("{noop}password")
                .roles("CHILD")
                .build();
        UserDetails teacher = User.withUsername("teacherUser")
                .password("{noop}password")
                .roles("CLASS_TEACHER")
                .build();
        UserDetails principal = User.withUsername("principalUser")
                .password("{noop}password")
                .roles("PRINCIPAL")
                .build();
        return new InMemoryUserDetailsManager(child, teacher, principal);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF for simplicity in this demo.
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/child/**").hasRole("CHILD")
                        .requestMatchers("/class-teacher/**").hasRole("CLASS_TEACHER")
                        .requestMatchers("/principal/**").hasRole("PRINCIPAL")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
