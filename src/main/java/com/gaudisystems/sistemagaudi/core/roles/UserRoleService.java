package com.gaudisystems.sistemagaudi.core.roles;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository repository;

    public List<UserRole> findAll() {
        return repository.findAll();
    }

    public UserRole findById(Long id) {
        Optional<UserRole> userRole = repository.findById(id);
        if (!userRole.isPresent()) {
            throw new UserRoleNotFoundException(id);
        }
        return userRole.get();
    }

    public void save(UserRole role) {
        repository.save(role);
    }

}
