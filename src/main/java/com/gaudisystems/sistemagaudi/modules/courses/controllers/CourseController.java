package com.gaudisystems.sistemagaudi.modules.courses.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.courses.dtos.CourseDto;
import com.gaudisystems.sistemagaudi.modules.courses.forms.CreateCourseForm;
import com.gaudisystems.sistemagaudi.modules.courses.forms.UpdateCourseForm;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;

public interface CourseController {
    
    public List<Course> findAll();

    public ResponseEntity<CourseDto> findById(long id);

    public ResponseEntity<CourseDto> save(CreateCourseForm courseModuleForm, UriComponentsBuilder uriBuilder);

    public ResponseEntity<CourseDto> update(long id, UpdateCourseForm courseModuleForm);

    public ResponseEntity<Void> delete(long id);
}
