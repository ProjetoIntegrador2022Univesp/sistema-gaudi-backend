package com.gaudisystems.sistemagaudi.modules.coursemodules.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.coursemodules.dtos.CourseModuleDto;
import com.gaudisystems.sistemagaudi.modules.coursemodules.forms.CreateCourseModuleForm;
import com.gaudisystems.sistemagaudi.modules.coursemodules.forms.UpdateCourseModuleForm;
import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;

public interface CourseModuleController {
    
    public List<CourseModule> findAll();

    public ResponseEntity<CourseModuleDto> findById(long id);

    public ResponseEntity<CourseModuleDto> save(CreateCourseModuleForm courseModuleForm, UriComponentsBuilder uriBuilder);

    public ResponseEntity<CourseModuleDto> update(long id, UpdateCourseModuleForm courseModuleForm);

    public ResponseEntity<Void> delete(long id);

    public List<CourseModule> findByCourse(long id);


}
