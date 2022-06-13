package com.gaudisystems.sistemagaudi.modules.guardian.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaudisystems.sistemagaudi.modules.guardian.controllers.dtos.GuardianDto;
import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.guardian.services.GuardianService;

@RestController
@RequestMapping("/guardians")
public class GuardianController {

    @Autowired
    GuardianService guardianService;
    
    @GetMapping
    public List<Guardian> findAll() {
        return guardianService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GuardianDto> findById(@PathVariable Long id) {
        Optional<Guardian> guardian = guardianService.findById(id);
        if(!guardian.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new GuardianDto(guardian.get()));
        
    }
}
