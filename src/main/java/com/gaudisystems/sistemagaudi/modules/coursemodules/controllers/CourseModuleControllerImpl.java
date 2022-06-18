package com.gaudisystems.sistemagaudi.modules.coursemodules.controllers;

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

import com.gaudisystems.sistemagaudi.modules.coursemodules.dtos.CourseModuleDto;
import com.gaudisystems.sistemagaudi.modules.coursemodules.forms.CreateCourseModuleForm;
import com.gaudisystems.sistemagaudi.modules.coursemodules.forms.UpdateCourseModuleForm;
import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;
import com.gaudisystems.sistemagaudi.modules.coursemodules.services.CourseModuleServiceImpl;

@RestController
@RequestMapping("/course-modules")
public class CourseModuleControllerImpl implements CourseModuleController {

    @Autowired
    private CourseModuleServiceImpl service;

    @Override
    @GetMapping
    public List<CourseModule> findAll() {
        return service.findAll();
        
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CourseModuleDto> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<CourseModuleDto> save(@RequestBody @Valid CreateCourseModuleForm form, UriComponentsBuilder uriBuilder) {
        CourseModule courseModule = form.toCouseModule();
        System.out.println("courseModule: " + courseModule.getName());
        service.save(courseModule);
        URI uri = uriBuilder.path("/course-modules/{id}").buildAndExpand(courseModule.getId()).toUri();
        return ResponseEntity.created(uri).body(new CourseModuleDto(courseModule));
    }

    @Override
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<CourseModuleDto> update(@PathVariable long id, @RequestBody @Valid UpdateCourseModuleForm form) {
        service.update(id, form);
        return null;
    }

    @Override
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/course/{id}")
    public List<CourseModule> findByCourse(@PathVariable long id) {
        return service.findByCourse(id);
    }

}
