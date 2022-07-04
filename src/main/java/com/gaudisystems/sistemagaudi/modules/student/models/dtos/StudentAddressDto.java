package com.gaudisystems.sistemagaudi.modules.student.models.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentAddressDto {
    private long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private String birthdate;
  

    public StudentAddressDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.cpf = student.getCpf();
        this.phone = student.getPhone();
        this.birthdate = student.getBirthdate();

       
       

    }

    public static List<StudentAddressDto> toStudentDto(List<Student> students) {
        return students.stream().map(StudentAddressDto::new).collect(Collectors.toList());
    }

    public static StudentAddressDto toStudentDto(Student student) {
        return new StudentAddressDto(student);
    }
}

