package com.gaudisystems.sistemagaudi.modules.classrooms.forms;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.gaudisystems.sistemagaudi.core.user.models.UserModel;
import com.gaudisystems.sistemagaudi.core.utils.Weekday;
import com.gaudisystems.sistemagaudi.modules.classrooms.models.Classroom;
import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateClassroomForm {

    @NotNull
    private String name;
    @NotNull
    private String description;
    @NotNull
    private List<Student> students = new ArrayList<>();
    @NotNull
    private LocalDate startDate;
    @NotNull
    private LocalDate endDate;
    @NotNull
    private List<UserModel> teachers = new ArrayList<>();
    @NotNull
    private String startTime;
    @NotNull
    private String endTime;
    @NotNull
    private Weekday weekday;
    @NotNull
    private CourseModule courseModule;

    public Classroom toClassroom() {
        return new Classroom(name, description, students, startDate, endDate, teachers, startTime, endTime, weekday,
                courseModule);
    }

}
