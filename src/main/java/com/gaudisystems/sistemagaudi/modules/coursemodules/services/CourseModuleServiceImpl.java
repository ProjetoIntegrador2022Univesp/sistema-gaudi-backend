package com.gaudisystems.sistemagaudi.modules.coursemodules.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gaudisystems.sistemagaudi.modules.coursemodules.dtos.CourseModuleDto;
import com.gaudisystems.sistemagaudi.modules.coursemodules.forms.UpdateCourseModuleForm;
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
    public ResponseEntity<CourseModuleDto> findById(long id) {

        Optional<CourseModule> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new CourseModuleDto(optional.get()));
    }

    @Override
    public CourseModule save(CourseModule courseModule) {
        
        return repository.save(courseModule);
    }

    @Override
    public ResponseEntity<CourseModuleDto> update(long id, UpdateCourseModuleForm form) {
        Optional<CourseModule> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        CourseModule courseModule = form.update(optional.get());
        courseModule = repository.save(courseModule);
        return ResponseEntity.ok().body(new CourseModuleDto(courseModule));
        

    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        Optional<CourseModule> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(optional.get());
        return ResponseEntity.noContent().build();
        
    }

    @Override
    public List<CourseModule> findByCourse(long id) {
        List<CourseModule> courseModules = new ArrayList<>();
        repository.findByCourseId(id).forEach(courseModules::add);
        return courseModules;
    }
    
}
