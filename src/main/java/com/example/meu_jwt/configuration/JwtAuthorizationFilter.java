package com.example.meu_jwt.configuration;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.meu_jwt.model.CustomGrantedAuthority;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String headerAuthorization = request.getHeader(SecurityConstants.HEADER_AUTHORIZATION);
        if (headerAuthorization == null || !headerAuthorization.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String headerAuthorization = request.getHeader(SecurityConstants.HEADER_AUTHORIZATION);
        if (headerAuthorization == null) {
            return null;
        }
        DecodedJWT decodedJWT = JWT
                .require(Algorithm.HMAC512(SecurityConstants.SECRET.getBytes()))
                .build()
                .verify(headerAuthorization.replace(SecurityConstants.TOKEN_PREFIX, ""));

        String user = decodedJWT.getSubject();
        List<CustomGrantedAuthority> authorities = Arrays.stream(
                decodedJWT
                    .getClaim("roles")
                    .asArray(String.class))
                .map(CustomGrantedAuthority::new)
                .collect(Collectors.toList());

        if (user == null) {
            return null;
        }
        return new UsernamePasswordAuthenticationToken(user,null, authorities);
    }
}
