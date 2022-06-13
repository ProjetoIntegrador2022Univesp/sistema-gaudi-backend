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
import com.gaudisystems.sistemagaudi.modules.student.controllers.dtos.StudentForm;
import com.gaudisystems.sistemagaudi.modules.student.controllers.dtos.UpdateStudentForm;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.repositories.StudentRepository;
import com.gaudisystems.sistemagaudi.modules.student.services.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;
    @Autowired
    private StudentRepository repository;
    @Autowired
    private GuardianRepository guardianRepository;
    
    
    @GetMapping
    public List<StudentDto> findAll() {
       return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> findById(@PathVariable Long id) {
        return service.findById(id);

    }

    @PostMapping
    @Transactional
    public ResponseEntity<StudentDto> save(@RequestBody @Valid StudentForm studentForm, UriComponentsBuilder uriBuilder) {
        Student student = studentForm.toStudent();

        GuardianForm guardianForm = new GuardianForm();
        List<Guardian> guardians = guardianForm.toGuardian(student.getGuardian());

        guardianRepository.saveAll(guardians);

        repository.save(student);

        URI uri = uriBuilder.path("/students/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(new StudentDto(student));
        
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<StudentDto> update(@PathVariable Long id, @RequestBody @Valid UpdateStudentForm form) {
        Optional<Student> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Student student = form.update(id, repository);
        return ResponseEntity.ok(new StudentDto(student)); 
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Student> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}

