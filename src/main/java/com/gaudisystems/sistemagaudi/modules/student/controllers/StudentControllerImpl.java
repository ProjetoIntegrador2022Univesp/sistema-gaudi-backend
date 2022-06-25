package com.gaudisystems.sistemagaudi.modules.student.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.gaudisystems.sistemagaudi.modules.guardian.controllers.dtos.GuardianForm;
import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.guardian.repositories.GuardianRepository;
import com.gaudisystems.sistemagaudi.modules.student.controllers.dtos.StudentDto;
import com.gaudisystems.sistemagaudi.modules.student.controllers.forms.StudentForm;
import com.gaudisystems.sistemagaudi.modules.student.controllers.forms.UpdateStudentForm;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.repositories.StudentRepository;
import com.gaudisystems.sistemagaudi.modules.student.services.StudentServiceImpl;

@RestController
@RequestMapping("/students")
public class StudentControllerImpl  implements IStudentController{

    @Autowired
    private StudentServiceImpl service;
    @Autowired
    private StudentRepository repository;
    @Autowired
    private GuardianRepository guardianRepository;
    
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
    public ResponseEntity<StudentDto> save(@RequestBody @Valid StudentForm studentForm, UriComponentsBuilder uriBuilder) {
        Student student = studentForm.toStudent();

        GuardianForm guardianForm = new GuardianForm();
        List<Guardian> guardians = guardianForm.toGuardian(student.getGuardian());

        guardianRepository.saveAll(guardians);

        repository.save(student);

        URI uri = uriBuilder.path("/students/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(new StudentDto(student));
        
    }

    @Override
    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable long id, @RequestBody @Valid UpdateStudentForm form) {
        Optional<Student> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Student student = form.update(id, repository);
        return ResponseEntity.ok(new StudentDto(student)); 
    }

    @Override  
    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        Optional<Student> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

   
  
   

}

