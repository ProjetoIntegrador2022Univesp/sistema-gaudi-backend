package com.gaudisystems.sistemagaudi.modules.installment.services;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;
import com.gaudisystems.sistemagaudi.modules.contract.repositories.ContractRepository;
import com.gaudisystems.sistemagaudi.modules.installment.controllers.dtos.InstallmentDto;
import com.gaudisystems.sistemagaudi.modules.installment.controllers.forms.CreateInstallmentForm;
import com.gaudisystems.sistemagaudi.modules.installment.controllers.forms.UpdateInstallmentForm;
import com.gaudisystems.sistemagaudi.modules.installment.models.Installment;
import com.gaudisystems.sistemagaudi.modules.installment.repositories.InstallmentRepository;

@Service
public class InstallmentServiceImpl implements IInstallmentService {

    @Autowired
    private InstallmentRepository repository;
    @Autowired
    private ContractRepository contractRepository;

    @Override
    public List<Installment> findAll() {

        return repository.findAll();
    }

    @Override
    public ResponseEntity<InstallmentDto> findById(long id) {
        Optional<Installment> optional = repository.findById(id);
        if(!optional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new InstallmentDto(optional.get()));

    }

    @Override
    public ResponseEntity<InstallmentDto> save(CreateInstallmentForm form, UriComponentsBuilder uriBuilder) {

        Optional<Contract> contractOptional = contractRepository.findById(form.getContractId());
        if(!contractOptional.isPresent()){
            return ResponseEntity.badRequest().build();
        }
        Contract contract = contractOptional.get();
        Installment installment = CreateInstallmentForm.toInstallment(form, contract);
        repository.save(installment);
        URI uri = uriBuilder.path("/installments/{id}").buildAndExpand(installment.getId()).toUri();
        return ResponseEntity.created(uri).body(new InstallmentDto(installment));
    }

    @Override
    public ResponseEntity<InstallmentDto> update(long id, UpdateInstallmentForm form) {
        Optional<Installment> optional = repository.findById(id);
        if(!optional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        Installment installment = form.update(optional.get());
        installment = repository.save(installment);
        return ResponseEntity.ok().body(new InstallmentDto(installment));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        Optional<Installment> optional = repository.findById(id);
        if(!optional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(optional.get().getId());
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<List<InstallmentDto>> findByStudentId(long id) {
        Optional<List<Installment>> optionals = repository.findByContractStudentId(id);
        if(!optionals.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(InstallmentDto.toInstallmentDto(optionals.get()));
    }

   

    

}
