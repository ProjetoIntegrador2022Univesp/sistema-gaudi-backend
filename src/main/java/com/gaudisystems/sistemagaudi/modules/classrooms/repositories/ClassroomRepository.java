package com.gaudisystems.sistemagaudi.modules.classrooms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaudisystems.sistemagaudi.modules.classrooms.models.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {

}
