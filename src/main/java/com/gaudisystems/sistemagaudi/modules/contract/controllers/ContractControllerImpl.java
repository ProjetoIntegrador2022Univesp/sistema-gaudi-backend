package com.gaudisystems.sistemagaudi.modules.contract.controllers;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.contract.forms.CreateContractForm;
import com.gaudisystems.sistemagaudi.modules.contract.services.ContractServiceImpl;

@RestController
@RequestMapping("/contract")
public class ContractControllerImpl implements ContractController {

    @Autowired
    private ContractServiceImpl service;

    @Override
    @GetMapping
    public List<ContractDto> findAll() {
        List<ContractDto> contracts = ContractDto.toContractDto(service.findAll());
        return contracts;
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ContractDto> findById(long id) {
        return service.findById(id);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<ContractDto> save(@RequestBody @Valid CreateContractForm form, UriComponentsBuilder uriBuilder) {
        return service.save(form, uriBuilder);
    }

    @Override
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<ContractDto> update(long id, UpdateContractForm form) {
        return service.update(id, form);
    }

    @Override
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(long id) {
        return service.delete(id);
    }

    
}
