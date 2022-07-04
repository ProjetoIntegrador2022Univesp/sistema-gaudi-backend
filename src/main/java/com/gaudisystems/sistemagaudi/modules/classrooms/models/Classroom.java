package com.gaudisystems.sistemagaudi.modules.classrooms.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gaudisystems.sistemagaudi.core.user.models.UserModel;
import com.gaudisystems.sistemagaudi.core.utils.Weekday;
import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Data;

@Data
@Entity
@Table(name = "classrooms")
public class Classroom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String startTime;
    private String endTime;
    
    @Enumerated(EnumType.STRING)
    private Weekday weekday;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Student> students;

    @ManyToMany
    private List<UserModel> teachers;
    
    @ManyToOne
    private CourseModule courseModule;

    public Classroom() {
    }

    public Classroom(String name, String description, List<Student> students, LocalDate startDate,
            LocalDate endDate,  List<UserModel> teachers, String startTime, String endTime,
            Weekday weekday, CourseModule courseModule) {
                
        this.name = name;
        this.description = description;
        this.students = students;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teachers = teachers;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekday = weekday;
        this.courseModule = courseModule;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

   

}
