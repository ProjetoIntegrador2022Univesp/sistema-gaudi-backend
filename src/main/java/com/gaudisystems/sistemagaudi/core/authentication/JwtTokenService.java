package com.gaudisystems.sistemagaudi.core.authentication;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.gaudisystems.sistemagaudi.core.user.models.UserModel;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenService {

    @Value("${sistemagaudi.jwt.secret}")
    private String secretkey;


    public String generateToken(Authentication auth) {
        UserModel loggedUser = (UserModel) auth.getPrincipal();
        System.out.println("id: "+String.valueOf(loggedUser.getId()));
        Date now = new Date();

        return Jwts.builder()
        .setIssuer("sistemagaudi")
        .setSubject(String.valueOf(loggedUser.getId()))
        .setIssuedAt(now)
        .setExpiration(new Date(now.getTime() + 86400000))
        .signWith(SignatureAlgorithm.HS256, "secretkey")
        .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token);
            System.out.println("valido");
            return true;
            
        } catch (Exception e) {
            System.out.println("invalido");
            return false;
        }
    }

    public Long getUserIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }

}