package com.gaudisystems.sistemagaudi.modules.student.controllers;

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

import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.models.dtos.StudentDto;
import com.gaudisystems.sistemagaudi.modules.student.models.forms.CreateStudentForm;
import com.gaudisystems.sistemagaudi.modules.student.models.forms.UpdateStudentForm;
import com.gaudisystems.sistemagaudi.modules.student.services.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentControllerImpl  implements IStudentController{

    @Autowired
    private StudentServiceImpl service;
    
    
    @Override
    @GetMapping
    public List<StudentDto> findAll() {
       return service.findAll();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findById(@PathVariable long id) {
        return service.findById(id);
    }
    
    @Override
    @Transactional
    @PostMapping
    public ResponseEntity<StudentDto> save(@RequestBody @Valid CreateStudentForm form, UriComponentsBuilder uriBuilder) {
        Student student = service.save(form);
        URI uri = uriBuilder.path("/students/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(new StudentDto(student));
    }


    @Override
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable long id, @RequestBody @Valid UpdateStudentForm form) {
         return service.update(id, form);
    }

    @Override  
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        return service.delete(id);
    }

   
  
   

}

