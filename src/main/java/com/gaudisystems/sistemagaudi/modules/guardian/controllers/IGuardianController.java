package com.gaudisystems.sistemagaudi.modules.guardian.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.guardian.models.dtos.GuardianDto;
import com.gaudisystems.sistemagaudi.modules.guardian.models.dtos.GuardianStudentDto;
import com.gaudisystems.sistemagaudi.modules.guardian.models.forms.CreateGuardianForm;
import com.gaudisystems.sistemagaudi.modules.guardian.models.forms.UpdateGuardianForm;

public interface IGuardianController {

    public List<GuardianDto> findAll();

    public ResponseEntity<GuardianDto> findById(long id);

    public ResponseEntity<GuardianStudentDto> save(CreateGuardianForm form, UriComponentsBuilder uriBuilder);

    public ResponseEntity<GuardianDto> update(long id, UpdateGuardianForm form);

    public ResponseEntity<Void> delete(long id);
    
}
