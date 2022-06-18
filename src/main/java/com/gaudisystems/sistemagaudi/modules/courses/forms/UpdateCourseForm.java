package com.gaudisystems.sistemagaudi.modules.courses.forms;

import com.gaudisystems.sistemagaudi.modules.courses.models.Course;

import lombok.Getter;

@Getter
public class UpdateCourseForm {

    private String name;
    private String description;

    public Course update(Course course) {
        if (name != null) course.setName(name);
        if (description != null) course.setDescription(description);
        return course;
    }

}
