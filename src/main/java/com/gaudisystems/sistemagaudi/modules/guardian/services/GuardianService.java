package com.gaudisystems.sistemagaudi.modules.guardian.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaudisystems.sistemagaudi.core.services.ApplicationService;
import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.guardian.repositories.GuardianRepository;

@Service
public class GuardianService implements ApplicationService{

    @Autowired
    private GuardianRepository guardianRepository;

    @Override
    public void save(Object object) {
    }

    @Override
    public void update(Object object) {
        guardianRepository.save((Guardian) object);
        
    }

    @Override
    public void delete(Object object) {
        
    }

    @Override
    public Optional<Guardian> findById(Long id) {
        Optional<Guardian> guardian = guardianRepository.findById(id);
        return guardian;
    }

    @Override
    public List<Guardian> findAll() {
        List<Guardian> guardians = guardianRepository.findAll();
        return guardians;
    }
    
}
