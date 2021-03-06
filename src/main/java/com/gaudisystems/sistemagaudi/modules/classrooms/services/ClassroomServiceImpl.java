package com.gaudisystems.sistemagaudi.modules.classrooms.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.classrooms.dtos.ClassroomDto;
import com.gaudisystems.sistemagaudi.modules.classrooms.forms.CreateClassroomForm;
import com.gaudisystems.sistemagaudi.modules.classrooms.forms.UpdateClassroomForm;
import com.gaudisystems.sistemagaudi.modules.classrooms.models.Classroom;
import com.gaudisystems.sistemagaudi.modules.classrooms.repositories.ClassroomRepository;
import com.gaudisystems.sistemagaudi.modules.coursemodules.dtos.CourseModuleDto;
import com.gaudisystems.sistemagaudi.modules.coursemodules.services.CourseModuleService;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.repositories.StudentRepository;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomRepository repository;
    @Autowired
    private CourseModuleService courseModuleService;
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Classroom> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<ClassroomDto> findById(long id) {
        Optional<Classroom> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new ClassroomDto(optional.get()));
    }

    @Override
    public ResponseEntity<ClassroomDto> save(CreateClassroomForm form, UriComponentsBuilder uriBuilder) {
        Classroom classroom = form.toClassroom();

        long id = classroom.getCourseModule().getId();
        ResponseEntity<CourseModuleDto> dto = courseModuleService.findById(id);
            if(dto.getStatusCode().is4xxClientError()) {
                return ResponseEntity.badRequest().build();
            }

        try{
            repository.save(classroom);
            return ResponseEntity.ok().body(new ClassroomDto(classroom));
        }catch(Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public ResponseEntity<ClassroomDto> update(long id, UpdateClassroomForm form) {
        Optional<Classroom> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Classroom obj = form.update(optional.get());
        obj = repository.save(obj);
        return ResponseEntity.ok().body(new ClassroomDto(obj));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        Optional<Classroom> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(optional.get().getId());
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<ClassroomDto> saveClassroomStudents(@Valid long classroomId, @Valid List<Long> studenstIds) {
        Optional<Classroom> optional = repository.findById(classroomId);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Classroom classroom = optional.get();

        for (Long studentId : studenstIds) {
            Optional<Student> optionalStudent = studentRepository.findById(studentId);
            
            if(!optionalStudent.isPresent()) {
                return ResponseEntity.notFound().build();        }
            Student student = optionalStudent.get();
    
            classroom.addStudent(student);
        }

        classroom = repository.save(classroom);
        return ResponseEntity.ok().body(new ClassroomDto(classroom));
    }




}
