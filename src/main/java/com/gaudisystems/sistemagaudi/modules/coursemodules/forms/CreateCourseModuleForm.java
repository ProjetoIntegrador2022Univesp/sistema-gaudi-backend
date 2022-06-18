package com.gaudisystems.sistemagaudi.modules.coursemodules.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;
import com.gaudisystems.sistemagaudi.modules.courses.Course;

import lombok.Getter;

@Getter
public class CreateCourseModuleForm {

    @NotNull @NotBlank @NotEmpty @Length(min = 3, max = 50)
    private String name;
    @NotNull 
    private Course course;

    public CourseModule toCouseModule() {
        return new CourseModule(name, course);
    }
    
}
