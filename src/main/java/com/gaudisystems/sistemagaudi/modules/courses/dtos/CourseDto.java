package com.gaudisystems.sistemagaudi.modules.courses.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.courses.models.Course;

import lombok.Getter;

@Getter
public class CourseDto {

    private Long id;
    private String name;
    private String description;

    public CourseDto(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.description = course.getDescription();
    }

    public static List<CourseDto> toCourseDto(List<Course> courses) {
        return courses.stream().map(CourseDto :: new).collect(Collectors.toList());
    }

}