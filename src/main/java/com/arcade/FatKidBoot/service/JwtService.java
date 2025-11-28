package com.arcade.FatKidBoot.service;


import com.arcade.FatKidBoot.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
    private String jwtSecret = null;

    public String generateToken(User user) {
        Map<String, Object> claims = new HashMap<>();
        return Jwts.
                builder()
                .claims().add(claims).subject(user.getUsername()).issuer("Arcade")
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 60 * 10 * 1000))
                .and().signWith(generateKey())
                .compact();
    }

    private SecretKey generateKey() {
        byte[] decode = Decoders.BASE64.decode(getJwtSecret());
        return Keys.hmacShaKeyFor(decode);
    }


    public String getJwtSecret() {
        return jwtSecret = "OG93VGtwZ2k4QUQwa1N0TnRpU0NINjRuYTgxWEV5dEc=";
    }

    public String extractUserName(String token) {
        return extractClaims(token , Claims::getSubject);
    }

    private <T> T extractClaims(String token, Function<Claims , T> claimResolver) {
        Claims claims = extractClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractClaims(String token) {
        return Jwts.parser()
                .verifyWith(generateKey())
                .build()
                .parseSignedClaims(token).getPayload();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaims(token, Claims::getExpiration);
    }
}
