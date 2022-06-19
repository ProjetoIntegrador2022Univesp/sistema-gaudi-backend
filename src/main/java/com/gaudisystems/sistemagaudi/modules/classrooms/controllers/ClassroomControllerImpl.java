package com.gaudisystems.sistemagaudi.modules.classrooms.controllers;

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

import com.gaudisystems.sistemagaudi.modules.classrooms.dtos.ClassroomDto;
import com.gaudisystems.sistemagaudi.modules.classrooms.forms.CreateClassroomForm;
import com.gaudisystems.sistemagaudi.modules.classrooms.forms.UpdateClassroomForm;
import com.gaudisystems.sistemagaudi.modules.classrooms.models.Classroom;
import com.gaudisystems.sistemagaudi.modules.classrooms.services.ClassroomServiceImpl;

@RestController
@RequestMapping("/classrooms")
public class ClassroomControllerImpl implements ClassroomController {

    @Autowired
    private ClassroomServiceImpl service;

    @Override
    @GetMapping
    public List<Classroom> findAll() {
        return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> findById(@PathVariable long id) {
        return service.findById(id);
    }

    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<ClassroomDto> save(@RequestBody @Valid CreateClassroomForm classroomForm, UriComponentsBuilder uriBuilder) {
        return service.save(classroomForm, uriBuilder);
    }

    @Override
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<ClassroomDto> update(@PathVariable long id, @RequestBody @Valid UpdateClassroomForm classroomForm) {
        return service.update(id, classroomForm);
    }

    @Override
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        return service.delete(id);
    }
    
}
