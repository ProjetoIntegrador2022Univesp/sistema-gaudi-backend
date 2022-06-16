package com.gaudisystems.sistemagaudi.core.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.gaudisystems.sistemagaudi.core.authentication.JwtTokenService;
import com.gaudisystems.sistemagaudi.core.user.models.UserModel;
import com.gaudisystems.sistemagaudi.core.user.repositories.UserRepository;

public class JwtAuthenticationFilter extends OncePerRequestFilter{

    public JwtAuthenticationFilter(JwtTokenService tokenService, UserRepository userRepository) {
        this.tokenService = tokenService;
        this.userRepository = userRepository;
    }

    private JwtTokenService tokenService;
    private UserRepository userRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                logger.info("AuthenticationFilter");

                String token =  retrieveToken(request);
                logger.info("validating token: " + token);
                boolean isValid = tokenService.validateToken(token);
                if(isValid){
                    logger.info("Token is valid");
                    authenticateClient(token);
                }
        
                 filterChain.doFilter(request, response);
    }

    private void authenticateClient(String token) {
        logger.info("Authenticating client");
        Long userId = tokenService.getUserIdFromToken(token);
        UserModel user = userRepository.findById(userId).get();
        for (GrantedAuthority authority : user.getAuthorities()) {
            logger.info("Authority: " + authority.getAuthority());
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String retrieveToken(HttpServletRequest request) {
        logger.info("Retrieving token from request");
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            logger.error("Token not found in request");
            return null;
        }
        return token.substring(7, token.length());
    }


    
}
