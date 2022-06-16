package com.gaudisystems.sistemagaudi.core.roles;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
@Entity
public class UserRole  implements GrantedAuthority {

    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;


    @Override
    public String getAuthority() {
        return name;
    }

    public UserRole() {
    }

    public UserRole(String name) {
        this.name = name;
    }

    
    
}
