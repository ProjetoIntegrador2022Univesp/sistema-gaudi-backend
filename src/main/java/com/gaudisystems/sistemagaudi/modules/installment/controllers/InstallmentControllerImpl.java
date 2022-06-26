package com.gaudisystems.sistemagaudi.modules.installment.controllers;

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

import com.gaudisystems.sistemagaudi.modules.installment.controllers.dtos.InstallmentDto;
import com.gaudisystems.sistemagaudi.modules.installment.controllers.forms.CreateInstallmentForm;
import com.gaudisystems.sistemagaudi.modules.installment.controllers.forms.UpdateInstallmentForm;
import com.gaudisystems.sistemagaudi.modules.installment.models.Installment;
import com.gaudisystems.sistemagaudi.modules.installment.services.InstallmentServiceImpl;

@RestController
@RequestMapping("/installments")
public class InstallmentControllerImpl implements IInstallmentController{

    @Autowired
    private InstallmentServiceImpl service;

    @Override
    @GetMapping
    public List<Installment> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<InstallmentDto> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<InstallmentDto> save(@RequestBody CreateInstallmentForm form, UriComponentsBuilder uriBuilder) {
        return service.save(form, uriBuilder);
    }

    @Override
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<InstallmentDto> update(@PathVariable long id, @RequestBody @Valid UpdateInstallmentForm form) {
        return service.update(id, form);
    }

    @Override
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        return service.delete(id);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<InstallmentDto>> findByStudentId(@PathVariable long id) {
        return service.findByStudentId(id);
    }
    
}
