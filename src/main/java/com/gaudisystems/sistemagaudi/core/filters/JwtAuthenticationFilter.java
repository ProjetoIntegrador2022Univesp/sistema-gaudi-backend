package com.gaudisystems.sistemagaudi.core.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

                String token =  retrieveToken(request);
                boolean isValid = tokenService.validateToken(token);
                if(isValid){
                    authenticateClient(token);
                }
        
                 filterChain.doFilter(request, response);
    }

    private void authenticateClient(String token) {
        Long userId = tokenService.getUserIdFromToken(token);
        UserModel user = userRepository.findById(userId).get();
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private String retrieveToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if(token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
            return null;
        }
        return token.substring(7, token.length());
    }


    
}
