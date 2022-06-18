package com.gaudisystems.sistemagaudi.modules.coursemodules.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Course course;

    public CourseModule() {
    }

    public CourseModule(String name, Course course, List<Classroom> classroom) {
        this.name = name;
        this.course = course;
    }

    public CourseModule(String name, Course course) {
        this.name = name;
        this.course = course;
    }

}
