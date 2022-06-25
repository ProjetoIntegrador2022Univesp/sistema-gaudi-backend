package com.gaudisystems.sistemagaudi.modules.contract.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.contract.controllers.ContractDto;
import com.gaudisystems.sistemagaudi.modules.contract.controllers.UpdateContractForm;
import com.gaudisystems.sistemagaudi.modules.contract.forms.CreateContractForm;
import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;

public interface ContractService {

    public List<Contract> findAll();

    public ResponseEntity<ContractDto> findById(long id);

    public ResponseEntity<ContractDto> save(CreateContractForm form,  UriComponentsBuilder uriBuilder);

    public ResponseEntity<ContractDto> update(long id, UpdateContractForm form);

    public ResponseEntity<Void> delete(long id);
}