package com.springTemplate.config.security;

import com.springTemplate.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value(value = "${jwt.expiration}")
    private String expiration;
    @Value(value = "${jwt.password}")
    private String password;

    public String newToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Date now = new Date();
        Date expire = new Date(now.getTime() + Long.parseLong(expiration));

        return Jwts.builder()
                .setIssuer("Authentication")
                .setSubject(user.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expire)
                .signWith(SignatureAlgorithm.HS256, password)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(this.password).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Long getUser(String token) {
        Claims claims = Jwts.parser().setSigningKey(this.password).parseClaimsJws(token).getBody();
        return Long.valueOf(claims.getSubject());
    }
}
