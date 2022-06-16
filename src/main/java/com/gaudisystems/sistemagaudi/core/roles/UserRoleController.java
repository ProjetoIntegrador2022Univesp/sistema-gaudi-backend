package com.gaudisystems.sistemagaudi.core.roles;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.guardian.controllers.dtos.GuardianDto;
import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.guardian.services.GuardianService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/roles")
public class UserRoleController {

    @Autowired
    UserRoleService service;
    
    @GetMapping
    public List<UserRole> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRole> findById(@PathVariable Long id) {
        Optional<UserRole> role = service.findById(id);
        if(!role.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(role.get());
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserRole> save(@RequestBody UserRole role, UriComponentsBuilder uriBuilder) {
        service.save(role);

        URI uri = uriBuilder.path("/roles/{id}").buildAndExpand(role.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserRole(role.getId(), role.getName()));
        
    }
    
}