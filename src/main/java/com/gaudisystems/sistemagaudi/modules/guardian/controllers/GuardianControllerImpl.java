package com.gaudisystems.sistemagaudi.modules.guardian.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.guardian.models.dtos.GuardianDto;
import com.gaudisystems.sistemagaudi.modules.guardian.models.dtos.GuardianStudentDto;
import com.gaudisystems.sistemagaudi.modules.guardian.models.forms.CreateGuardianForm;
import com.gaudisystems.sistemagaudi.modules.guardian.models.forms.UpdateGuardianForm;
import com.gaudisystems.sistemagaudi.modules.guardian.services.GuardianServiceImpl;

@RestController
@RequestMapping("/guardians")
public class GuardianControllerImpl implements IGuardianController {

    @Autowired
    GuardianServiceImpl service;
    
    @Override
    @GetMapping
    public List<GuardianDto> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GuardianDto> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<GuardianStudentDto> save(@RequestBody @Valid CreateGuardianForm form, UriComponentsBuilder uriBuilder) {
        Guardian guardian = service.save(form);
        URI uri = uriBuilder.path("/guardians/{id}").buildAndExpand(guardian.getId()).toUri();
        return ResponseEntity.created(uri).body(new GuardianStudentDto(guardian));
    }

    @Override
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<GuardianDto> update(@PathVariable long id, @RequestBody @Valid UpdateGuardianForm form) {
        return service.update(id, form);
    }

    @Override
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        return service.delete(id);
    }
}
