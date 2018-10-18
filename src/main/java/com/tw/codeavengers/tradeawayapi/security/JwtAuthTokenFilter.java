package com.tw.codeavengers.tradeawayapi.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthTokenFilter extends OncePerRequestFilter {

    @Value("${jwt.headerName}")
    private String tokenHeader;

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        if (!(request.getRequestURI().startsWith("/public/") || request.getMethod().equals("OPTIONS"))) {
            try {
                String tokenHeader = request.getHeader(this.tokenHeader);

                Token token = tokenUtils.parse(tokenHeader.replaceFirst("Bearer ", ""));
                SecurityContextHolder.getContext().setAuthentication(
                        new UsernamePasswordAuthenticationToken(token, null,
                                Collections.singletonList(new SimpleGrantedAuthority(token.getRoles()))));

            } catch (Exception e) {
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED,"Error while parsing JWT token, check logs");
                e.printStackTrace();
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

}
