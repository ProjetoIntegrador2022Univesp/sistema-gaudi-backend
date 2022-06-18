package com.gaudisystems.sistemagaudi.modules.courses.forms;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gaudisystems.sistemagaudi.modules.courses.models.Course;

import lombok.Getter;

@Getter
public class CreateCourseForm {

    @NotNull @NotBlank @NotEmpty @Length(min = 3, max = 50)
    private String name;
    @NotNull @NotBlank @NotEmpty @Length(min = 3, max = 50)
    private String description;

    public Course toCourse() {
        return new Course(name, description);
    }

}
