package com.example.meu_jwt.configuration;

public class SecurityConstants {

    public static final String SECRET = "meu_segredo";

    public static final long EXPIRATION_TIME = 1000l * 60l * 60l; // 1 hora

    public static final String TOKEN_PREFIX = "Bearer ";

    public static final String HEADER_AUTHORIZATION = "Authorization";
}
