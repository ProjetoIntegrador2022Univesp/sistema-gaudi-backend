package com.gaudisystems.sistemagaudi.modules.coursemodules.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;
import com.gaudisystems.sistemagaudi.modules.coursemodules.services.CourseModuleService;

@RestController
@RequestMapping("/course-modules")
public class CourseModuleControllerImpl implements CourseModuleController {

    @Autowired
    private CourseModuleService courseModuleService;

    @Override
    @GetMapping
    public List<CourseModule> findAll() {
        return courseModuleService.findAll();
        
    }

    @Override
    public CourseModule findById(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public CourseModule save(CourseModule courseModule) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void delete(long id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<CourseModule> findByCourse(long id) {
        // TODO Auto-generated method stub
        return null;
    }

    
}
