package com.gaudisystems.sistemagaudi.modules.courses.controllers;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.courses.dtos.CourseDto;
import com.gaudisystems.sistemagaudi.modules.courses.forms.CreateCourseForm;
import com.gaudisystems.sistemagaudi.modules.courses.forms.UpdateCourseForm;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;
import com.gaudisystems.sistemagaudi.modules.courses.services.CourseServiceImpl;

@RestController
@RequestMapping("/courses")
public class CourseControllerImpl implements CourseController {

    @Autowired
    private CourseServiceImpl service;

    @Override
    @GetMapping
    public List<Course> findAll() {
        return service.findAll();
        
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CourseDto> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<CourseDto> save(@RequestBody @Valid CreateCourseForm form, UriComponentsBuilder uriBuilder) {
        Course course = form.toCourse();
        System.out.println("course: " + course.getName());
        service.save(course);
        URI uri = uriBuilder.path("/courses/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(uri).body(new CourseDto(course));
    }

    @Override
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<CourseDto> update(@PathVariable long id, @RequestBody @Valid UpdateCourseForm form) {
        return service.update(id, form);
    }

    @Override
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
