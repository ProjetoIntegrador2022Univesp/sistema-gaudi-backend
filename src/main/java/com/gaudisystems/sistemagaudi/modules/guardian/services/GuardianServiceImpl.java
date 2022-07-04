package com.gaudisystems.sistemagaudi.modules.guardian.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.guardian.models.dtos.GuardianDto;
import com.gaudisystems.sistemagaudi.modules.guardian.models.forms.CreateGuardianForm;
import com.gaudisystems.sistemagaudi.modules.guardian.models.forms.UpdateGuardianForm;
import com.gaudisystems.sistemagaudi.modules.guardian.repositories.IGuardianRepository;

@Service
public class GuardianServiceImpl implements IGuardianService{

    @Autowired
    private IGuardianRepository guardianRepository;

    @Override
    public List<GuardianDto> findAll() {
        List<Guardian> guardians = guardianRepository.findAll();

        return GuardianDto.toGuardianDto(guardians);
    }

    @Override
    public ResponseEntity<GuardianDto> findById(Long id) {
        Optional<Guardian> guardian = guardianRepository.findById(id);
        if(!guardian.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new GuardianDto(guardian.get()));
    }

    @Override
    public Guardian save(CreateGuardianForm form) {
        Guardian guardian = form.toGuardian();
        return guardianRepository.save(guardian);
    }

    @Override
    public ResponseEntity<GuardianDto> update(long id, UpdateGuardianForm form){
        Optional<Guardian> optional = guardianRepository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Guardian guardian = optional.get();
        guardian = form.update(guardian);
        guardianRepository.save(guardian);
        return ResponseEntity.ok(new GuardianDto(guardian));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        Optional<Guardian> guardian = guardianRepository.findById(id);
        if(!guardian.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        guardianRepository.delete(guardian.get());
        return ResponseEntity.noContent().build();
        
    }

    

    
    
}
