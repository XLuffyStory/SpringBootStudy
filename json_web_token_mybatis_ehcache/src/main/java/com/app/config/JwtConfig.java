package com.app.config;

import java.util.Date;

import org.springframework.cache.annotation.Cacheable;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JWT 常规配置
 */
public class JwtConfig {

    /**
     * 这个加密key一般不开放
     */
    public static final String SECRET_KEY = "abcdefg1234567890";

    /**
     * 加密算法
     */
    public static final SignatureAlgorithm SIGNATURE_ALGORITHM = SignatureAlgorithm.HS256;

    /**
     * JWT 过期时间（1小时）
     */
    public static final Date EXPIRATION_DATE = new Date(System.currentTimeMillis() + 3600000);

}
