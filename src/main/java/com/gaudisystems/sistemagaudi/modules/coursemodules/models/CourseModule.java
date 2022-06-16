package com.gaudisystems.sistemagaudi.modules.coursemodules.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.gaudisystems.sistemagaudi.modules.classrooms.Classroom;
import com.gaudisystems.sistemagaudi.modules.courses.Course;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
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

}
