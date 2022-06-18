package com.gaudisystems.sistemagaudi.core.roles;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


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
        UserRole role = service.findById(id);
       
        return ResponseEntity.ok(role);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserRoleDto> save(@RequestBody @Valid UserRoleForm form, UriComponentsBuilder uriBuilder) {
        UserRole role = form.toUserRole();
        service.save(role);

        URI uri = uriBuilder.path("/roles/{id}").buildAndExpand(role.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserRoleDto(role));
        
    }
    
}
