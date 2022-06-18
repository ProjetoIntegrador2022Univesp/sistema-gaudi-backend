package com.gaudisystems.sistemagaudi.modules.coursemodules.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.classrooms.Classroom;
import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;

import lombok.Getter;

@Getter
public class CourseModuleDto extends CourseModule {

    private long id;
    private String name;
    private Course course;
    private List<Classroom> classroom;

    public CourseModuleDto(CourseModule courseModule) {
        this.id = courseModule.getId();
        this.name = courseModule.getName();
        this.course = courseModule.getCourse();
        this.classroom = courseModule.getClassroom();
    }

    public static List<CourseModuleDto> toCouseModuleDto(List<CourseModule> courseModules) {
        return courseModules.stream().map(CourseModuleDto :: new).collect(Collectors.toList());
    }
    
}
