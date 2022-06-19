package com.gaudisystems.sistemagaudi.modules.classrooms.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.gaudisystems.sistemagaudi.modules.classrooms.dtos.ClassroomDto;
import com.gaudisystems.sistemagaudi.modules.classrooms.forms.CreateClassroomForm;
import com.gaudisystems.sistemagaudi.modules.classrooms.forms.UpdateClassroomForm;
import com.gaudisystems.sistemagaudi.modules.classrooms.models.Classroom;

public interface ClassroomController {

    public List<Classroom> findAll();

    public ResponseEntity<ClassroomDto> findById(long id);

    public ResponseEntity<ClassroomDto> save(CreateClassroomForm classroomForm, UriComponentsBuilder uriBuilder);

    public ResponseEntity<ClassroomDto> update(long id, UpdateClassroomForm classroomForm);

    public ResponseEntity<Void> delete(long id);
}
