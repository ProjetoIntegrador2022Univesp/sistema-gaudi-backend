package com.gaudisystems.sistemagaudi.modules.courses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaudisystems.sistemagaudi.modules.courses.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
