package com.gaudisystems.sistemagaudi.modules.student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.models.dtos.StudentDto;
import com.gaudisystems.sistemagaudi.modules.student.models.forms.CreateStudentForm;
import com.gaudisystems.sistemagaudi.modules.student.models.forms.UpdateStudentForm;
import com.gaudisystems.sistemagaudi.modules.student.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = repository.findAll();
        return StudentDto.toStudentDto(students);
    }

    @Override
    public ResponseEntity<StudentDto> findById(long id) {
        Optional<Student> student = repository.findById(id);
        if(!student.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new StudentDto(student.get()));
    }

    @Override
    public Student save(CreateStudentForm form) {
        Student student = form.toStudent();
        
        return repository.save(student);
    }

    @Override
    public ResponseEntity<StudentDto> update(long id, UpdateStudentForm form) {
        Optional<Student> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Student student = optional.get();
        student = form.update(student);
        repository.saveAndFlush(student);
        return ResponseEntity.ok(new StudentDto(student));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        Optional<Student> student = repository.findById(id);
        if(!student.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.delete(student.get());
        return ResponseEntity.noContent().build();
    }

  

   
    
}
