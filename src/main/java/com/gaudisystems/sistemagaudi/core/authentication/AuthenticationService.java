package com.gaudisystems.sistemagaudi.core.authentication;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gaudisystems.sistemagaudi.core.user.UserModel;
import com.gaudisystems.sistemagaudi.core.user.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user = userRepository.findByEmail(username);
        if(user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFoundException("User not found");

    }
    
}
