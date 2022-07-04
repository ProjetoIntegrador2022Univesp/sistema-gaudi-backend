package com.gaudisystems.sistemagaudi.modules.classrooms.dtos;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.core.user.models.UserModel;
import com.gaudisystems.sistemagaudi.core.utils.Weekday;
import com.gaudisystems.sistemagaudi.modules.classrooms.models.Classroom;
import com.gaudisystems.sistemagaudi.modules.coursemodules.models.CourseModule;

import lombok.Getter;

@Getter
public class ClassroomStudentDto {

    private Long id;
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private List<UserModel> teachers;
    private String startTime;
    private String endTime;
    private Weekday weekday;
    private CourseModule courseModule;

    public ClassroomStudentDto(Classroom classroom) {
        this.id = classroom.getId();
        this.name = classroom.getName();
        this.description = classroom.getDescription();
        this.startDate = classroom.getStartDate();
        this.endDate = classroom.getEndDate();
        this.teachers = classroom.getTeachers();
        this.startTime = classroom.getStartTime();
        this.endTime = classroom.getEndTime();
        this.weekday = classroom.getWeekday();
        this.courseModule = classroom.getCourseModule();
    }

    public static List<ClassroomStudentDto> toClassroomDto(List<Classroom> classrooms) {
        return classrooms.stream().map(ClassroomStudentDto :: new).collect(Collectors.toList());
    }

}
