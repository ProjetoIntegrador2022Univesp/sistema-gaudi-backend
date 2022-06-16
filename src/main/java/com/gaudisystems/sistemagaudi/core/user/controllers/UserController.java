package com.gaudisystems.sistemagaudi.core.user.controllers;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.core.roles.UserRole;
import com.gaudisystems.sistemagaudi.core.roles.UserRoleRepository;
import com.gaudisystems.sistemagaudi.core.roles.UserRoleService;
import com.gaudisystems.sistemagaudi.core.user.controllers.dtos.UpdateUserForm;
import com.gaudisystems.sistemagaudi.core.user.controllers.dtos.UpdateUserRole;
import com.gaudisystems.sistemagaudi.core.user.controllers.dtos.UpdateUserRoleForm;
import com.gaudisystems.sistemagaudi.core.user.controllers.dtos.UserDto;
import com.gaudisystems.sistemagaudi.core.user.controllers.dtos.UserForm;
import com.gaudisystems.sistemagaudi.core.user.models.UserModel;
import com.gaudisystems.sistemagaudi.core.user.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleRepository userRoleRepository;
    
    @GetMapping
    public List<UserDto> findAll() {
        List<UserModel> users = userRepository.findAll();

        return UserDto.toUserDto(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable Long id) {
        Optional<UserModel> user = userRepository.findById(id);
        if(!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new UserDto(user.get()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserDto> save(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder) {
        UserModel user = form.convert();
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        URI uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDto(user));
        
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UserDto> update(@PathVariable Long id, @RequestBody @Valid UpdateUserForm form) {
        Optional<UserModel> optional = userRepository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        UserModel user = form.update(id, userRepository);
        return ResponseEntity.ok(new UserDto(user)); 
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<UserModel> optional = userRepository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/role")
    @Transactional
    public ResponseEntity<UserDto> updateRole(@PathVariable Long id, @RequestBody @Valid UpdateUserRoleForm form) {
        Optional<UserModel> optional = userRepository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        UserModel user = form.update(id, userRepository, userRoleRepository);
        return ResponseEntity.ok(new UserDto(user)); 
    }

  
    
    


}
