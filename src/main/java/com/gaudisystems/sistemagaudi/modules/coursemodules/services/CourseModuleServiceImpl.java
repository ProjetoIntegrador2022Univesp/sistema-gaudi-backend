package com.gaudisystems.sistemagaudi.modules.coursemodules.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gaudisystems.sistemagaudi.modules.coursemodules.dtos.CourseModuleDto;
import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;
import com.gaudisystems.sistemagaudi.modules.coursemodules.repositories.CourseModuleRepository;

@Service
public class CourseModuleServiceImpl implements CourseModuleService {

    @Autowired
    private CourseModuleRepository repository;

    @Override
    public List<CourseModule> findAll() {
        return repository.findAll();
    }

    @Override
    public CourseModule findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseModule save(CourseModule courseModule) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ArrayList<CourseModule> findByCourse(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    
    
}
