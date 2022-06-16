package com.gaudisystems.sistemagaudi.modules.coursemodules.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;

public interface CourseModuleRepository extends JpaRepository<CourseModule, Long> {

    
}
