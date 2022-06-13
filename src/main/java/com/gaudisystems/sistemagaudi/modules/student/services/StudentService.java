package com.gaudisystems.sistemagaudi.modules.student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gaudisystems.sistemagaudi.core.services.ApplicationService;
import com.gaudisystems.sistemagaudi.modules.student.controllers.dtos.StudentDto;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.repositories.StudentRepository;

@Service
public class StudentService implements ApplicationService {

    @Autowired
    private StudentRepository repository;
    

    @Override
    public void save(Object student) {
        
    }

    @Override
    public void update(Object object) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Object object) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ResponseEntity<StudentDto> findById(Long id) {
        Optional<Student> student = repository.findById(id);
        if(!student.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new StudentDto(student.get()));
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = repository.findAll();
        return StudentDto.toStudentDto(students);
    }
    
}
