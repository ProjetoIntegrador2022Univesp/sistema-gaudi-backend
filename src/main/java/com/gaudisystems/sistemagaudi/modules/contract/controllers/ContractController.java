package com.gaudisystems.sistemagaudi.modules.contract.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.contract.forms.CreateContractForm;


public interface ContractController {

    public List<ContractDto> findAll();

    public ResponseEntity<ContractDto> findById(long id);

    public ResponseEntity<ContractDto> save(CreateContractForm classroomForm, UriComponentsBuilder uriBuilder);

    public ResponseEntity<ContractDto> update(long id, UpdateContractForm classroomForm);

    public ResponseEntity<Void> delete(long id);
}
