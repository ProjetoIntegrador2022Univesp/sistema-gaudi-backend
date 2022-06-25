package com.gaudisystems.sistemagaudi.modules.student.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gaudisystems.sistemagaudi.modules.student.controllers.dtos.StudentDto;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

public interface IStudentService {
    
    public List<StudentDto> findAll();

    public void save(Student student);

    public void update(Student student);

    public void delete(Student student);

    public ResponseEntity<StudentDto> findById(Long id);

    
}
