package com.gaudisystems.sistemagaudi.modules.coursemodules.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;
import com.gaudisystems.sistemagaudi.modules.courses.dtos.CourseDto;

import lombok.Getter;

@Getter
public class CourseModuleDto{

    private long id;
    private String name;
    private CourseDto course;

    public CourseModuleDto(CourseModule courseModule) {

        this.id = courseModule.getId();
        this.name = courseModule.getName();
        this.course = new CourseDto(courseModule.getCourse());
    }

    public static List<CourseModuleDto> toCouseModuleDto(List<CourseModule> courseModules) {
        return courseModules.stream().map(CourseModuleDto :: new).collect(Collectors.toList());
    }
    
}
