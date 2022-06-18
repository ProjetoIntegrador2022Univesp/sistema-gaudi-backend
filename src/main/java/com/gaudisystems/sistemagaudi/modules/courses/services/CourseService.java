package com.gaudisystems.sistemagaudi.modules.courses.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gaudisystems.sistemagaudi.modules.courses.dtos.CourseDto;
import com.gaudisystems.sistemagaudi.modules.courses.forms.UpdateCourseForm;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;

public interface CourseService {

    public List<Course> findAll();

    public ResponseEntity<CourseDto> findById(long id);

    public Course save(Course course);

    public ResponseEntity<CourseDto> update(long id, UpdateCourseForm form);

    public ResponseEntity<Void> delete(long id);

}
