package com.gaudisystems.sistemagaudi.modules.coursemodules.forms;

import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;

public class UpdateCourseModuleForm {

    private String name;
    private Course course;

    public CourseModule update(CourseModule courseModule) {
        if(name != null) courseModule.setName(name);
        if(course != null) courseModule.setCourse(course);
        return courseModule;
        
    }
}
