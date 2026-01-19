package com.example.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.ecommerce.security.jwt.AuthEntryPointJwt;
import com.example.ecommerce.security.jwt.AuthTokenFilter;
import com.example.ecommerce.security.services.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired 
    AuthEntryPointJwt authEntryPointJwt;

    @Bean
    AuthTokenFilter authenticatioTokenFilter(){
        return new AuthTokenFilter();
    }

    
    // Authentification provider:
    @Bean 
    public DaoAuthenticationProvider authenticationProvider(){

        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    // Authentication manager :
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig){
        return authConfig.getAuthenticationManager();
    }

    // security filter chaine :
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        http.csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authHttpReqs -> authHttpReqs
            .requestMatchers("/error").permitAll()
            .requestMatchers("/api/v2/auth/**").permitAll()
            .requestMatchers("/v3/api-docs/**").permitAll()
            .requestMatchers("/swagger-ui/**").permitAll()
            .requestMatchers("/api/v2/admin/**").permitAll()
            .requestMatchers("/api/v2/public/**").permitAll()
            .requestMatchers("/api/test/**").permitAll()
            .requestMatchers("/images/**").permitAll()
            .requestMatchers("/").permitAll()
            .requestMatchers("/swagger-ui.html").permitAll()
            .anyRequest().authenticated())
        .sessionManagement(session -> session.sessionCreationPolicy(
            SessionCreationPolicy.STATELESS
        )).exceptionHandling(exception -> exception.authenticationEntryPoint(authEntryPointJwt));
        http.authenticationProvider(authenticationProvider());
        http.addFilterBefore(authenticatioTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    // customize the webSecurityCustomizer.
    // ....
}