package com.gaudisystems.sistemagaudi.modules.student.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.models.dtos.StudentDto;
import com.gaudisystems.sistemagaudi.modules.student.models.forms.CreateStudentForm;
import com.gaudisystems.sistemagaudi.modules.student.models.forms.UpdateStudentForm;

public interface IStudentService {
    
    public List<StudentDto> findAll();

    public ResponseEntity<StudentDto> findById(long id);

    public Student save(CreateStudentForm form);

    public ResponseEntity<StudentDto> update(long id, UpdateStudentForm form);

    public ResponseEntity<Void> delete(long id);


    
}
