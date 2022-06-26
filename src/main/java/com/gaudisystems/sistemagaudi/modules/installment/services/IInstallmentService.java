package com.gaudisystems.sistemagaudi.modules.installment.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.installment.controllers.dtos.InstallmentDto;
import com.gaudisystems.sistemagaudi.modules.installment.controllers.forms.CreateInstallmentForm;
import com.gaudisystems.sistemagaudi.modules.installment.controllers.forms.UpdateInstallmentForm;
import com.gaudisystems.sistemagaudi.modules.installment.models.Installment;

public interface IInstallmentService {

    public List<Installment> findAll();

    public ResponseEntity<InstallmentDto> findById(long id);

    public ResponseEntity<InstallmentDto> save(CreateInstallmentForm form, UriComponentsBuilder uriBuilder);

    public ResponseEntity<InstallmentDto> update(long id, UpdateInstallmentForm form);

    public ResponseEntity<Void> delete(long id);

}
