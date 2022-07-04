package com.gaudisystems.sistemagaudi.modules.guardian.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.guardian.models.dtos.GuardianDto;
import com.gaudisystems.sistemagaudi.modules.guardian.models.forms.CreateGuardianForm;
import com.gaudisystems.sistemagaudi.modules.guardian.models.forms.UpdateGuardianForm;

public interface IGuardianService {
    
    public List<GuardianDto> findAll();

    public ResponseEntity<GuardianDto> findById(Long id);

    public Guardian save(CreateGuardianForm form);

    public ResponseEntity<GuardianDto> update(long id, UpdateGuardianForm form);

    public ResponseEntity<Void> delete(long id);


}
