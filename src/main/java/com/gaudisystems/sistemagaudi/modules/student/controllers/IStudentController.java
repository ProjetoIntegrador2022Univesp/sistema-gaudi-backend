package com.gaudisystems.sistemagaudi.modules.student.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.student.controllers.dtos.StudentDto;
import com.gaudisystems.sistemagaudi.modules.student.controllers.forms.StudentForm;
import com.gaudisystems.sistemagaudi.modules.student.controllers.forms.UpdateStudentForm;

public interface IStudentController {
    public List<StudentDto> findAll();

    public ResponseEntity<StudentDto> findById(long id);

    public ResponseEntity<StudentDto> save(StudentForm form, UriComponentsBuilder uriBuilder);

    public ResponseEntity<StudentDto> update(long id, UpdateStudentForm form);

    public ResponseEntity<Void> delete(long id);
    
}
