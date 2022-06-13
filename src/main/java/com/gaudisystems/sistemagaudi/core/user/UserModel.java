package com.gaudisystems.sistemagaudi.core.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gaudisystems.sistemagaudi.core.utils.Role;
import com.gaudisystems.sistemagaudi.modules.classrooms.Classroom;

import lombok.Data;

@Entity
@Data
@Table(name = "users")
public class UserModel implements UserDetails{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<UserProfile> userProfile = new ArrayList<>();
    @ManyToMany(mappedBy = "teachers", cascade = CascadeType.ALL)
    private List<Classroom> classrooms = new ArrayList<>();

    public UserModel() {
    }

    public UserModel(String name, String email, String password, Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;


    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.userProfile;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
