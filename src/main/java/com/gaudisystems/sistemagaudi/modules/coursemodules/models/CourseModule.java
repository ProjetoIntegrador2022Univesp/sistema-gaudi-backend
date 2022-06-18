package com.gaudisystems.sistemagaudi.modules.coursemodules.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gaudisystems.sistemagaudi.modules.classrooms.Classroom;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;

import lombok.Data;


@Entity
@Data
public class CourseModule {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToOne
    private Course course;
    @OneToMany
    private List<Classroom> classroom;

    public CourseModule() {
    }

    public CourseModule(String name, Course course, List<Classroom> classroom) {
        this.name = name;
        this.course = course;
        this.classroom = classroom;
    }

    public CourseModule(String name, Course course) {
        this.name = name;
        this.course = course;
    }

}
