package com.tw.codeavengers.tradeawayapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.session.SessionManagementFilter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Autowired
    private JwtAuthTokenFilter jwtAuthTokenFilter;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint)
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authorizeRequests()
                .antMatchers("/public/*").permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .anyRequest().authenticated();

//        http.addFilterBefore(new CorsFilter(), SessionManagementFilter.class);
        http.addFilterBefore(jwtAuthTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
