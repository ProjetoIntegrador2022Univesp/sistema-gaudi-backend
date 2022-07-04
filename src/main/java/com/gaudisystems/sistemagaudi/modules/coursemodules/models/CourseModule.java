package com.gaudisystems.sistemagaudi.modules.coursemodules.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gaudisystems.sistemagaudi.modules.classrooms.models.Classroom;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;

import lombok.Data;


@Entity
@Data
@Table(name = "course_modules")
public class CourseModule {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @OneToMany(mappedBy = "courseModule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Classroom> classrooms;

    public CourseModule() {
    }

    public CourseModule(String name, Course course, List<Classroom> classroom) {
        this.name = name;
        this.course = course;
        this.classrooms = classroom;
    }

    public CourseModule(String name, Course course) {
        this.name = name;
        this.course = course;
    }

}
