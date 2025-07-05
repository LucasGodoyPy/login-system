package com.lucas_login.Login.config;

import com.lucas_login.Login.service.UserDetailServicelmpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class Security_Config {

    private final UserDetailServicelmpl userDetailService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/v1/home").authenticated()
                        .requestMatchers("/v1/admin").hasAuthority("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                        .failureUrl("/login?error")
                        .successHandler((request, response, authentication) -> {
                            var authorities = authentication.getAuthorities();
                            boolean isAdmin = authorities.stream()
                                    .anyMatch(auth -> auth.getAuthority().equals("ADMIN"));

                            if (isAdmin) {
                                response.sendRedirect("/v1/admin");
                            } else {
                                response.sendRedirect("/v1/home");
                            }
                        })
                )

                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
