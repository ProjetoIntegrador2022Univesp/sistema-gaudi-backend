package com.gaudisystems.sistemagaudi.modules.student.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaudisystems.sistemagaudi.modules.student.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    Optional<Student> findById(Long id);

}
