package com.gaudisystems.sistemagaudi.modules.coursemodules.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gaudisystems.sistemagaudi.modules.coursemodules.dtos.CourseModuleDto;
import com.gaudisystems.sistemagaudi.modules.coursemodules.forms.UpdateCourseModuleForm;
import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;

public interface CourseModuleService {

    public List<CourseModule> findAll();

    public ResponseEntity<CourseModuleDto> findById(long id);

    public CourseModule save(CourseModule courseModule);

    public ResponseEntity<CourseModuleDto> update(long id, UpdateCourseModuleForm form);

    public ResponseEntity<Void> delete(long id);

    public List<CourseModule> findByCourse(long id);
    
}
