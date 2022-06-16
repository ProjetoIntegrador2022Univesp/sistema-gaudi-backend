package com.gaudisystems.sistemagaudi.modules.coursemodules.controllers;

import java.util.List;

import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;

public interface CourseModuleController {
    
    public List<CourseModule> findAll();

    public CourseModule findById(long id);

    public CourseModule save(CourseModule courseModule);

    public void delete(long id);

    public List<CourseModule> findByCourse(long id);


}
