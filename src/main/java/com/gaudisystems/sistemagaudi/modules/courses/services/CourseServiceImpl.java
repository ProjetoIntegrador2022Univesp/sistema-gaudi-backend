package com.gaudisystems.sistemagaudi.modules.courses.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.gaudisystems.sistemagaudi.modules.courses.dtos.CourseDto;
import com.gaudisystems.sistemagaudi.modules.courses.forms.CreateCourseForm;
import com.gaudisystems.sistemagaudi.modules.courses.forms.UpdateCourseForm;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;
import com.gaudisystems.sistemagaudi.modules.courses.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private CourseRepository repository;

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public ResponseEntity<CourseDto> findById(long id) {
        Optional<Course> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(new CourseDto(optional.get()));
    }

    @Override
    public Course save(CreateCourseForm form) {
        Course course = form.toCourse();
        return repository.save(course);
    }

    @Override
    public ResponseEntity<CourseDto> update(long id, UpdateCourseForm form) {
        Optional<Course> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Course course = form.update(optional.get());
        course = repository.save(course);
        return ResponseEntity.ok().body(new CourseDto(course));
    }

    @Override
    public ResponseEntity<Void> delete(long id) {
        Optional<Course> optional = repository.findById(id);
        if(!optional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(optional.get().getId());
        return ResponseEntity.noContent().build();
    }

    

  

}
