package com.gaudisystems.sistemagaudi.modules.courses;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gaudisystems.sistemagaudi.modules.classrooms.Classroom;

import lombok.Data;

@Entity
@Data
@Table(name = "course_modules")
public class CourseModule {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "courseModule")
    private List<Classroom> classrooms;
    @ManyToOne
    private Course course;

}
