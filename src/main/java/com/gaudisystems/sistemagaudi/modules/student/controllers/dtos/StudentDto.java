package com.gaudisystems.sistemagaudi.modules.student.controllers.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.address.AddressDto;
import com.gaudisystems.sistemagaudi.modules.guardian.controllers.dtos.GuardianDto;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private long id;
    private String name;
    private String email;
    private String password;
    private String cpf;
    private String rg;
    private String phone;
    private List<AddressDto> addresses;
    private String birthdate;
    private List<GuardianDto> guardian;

    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.cpf = student.getCpf();
        this.rg = student.getRg();
        this.phone = student.getPhone();
        //this.addresses = student.getAddresses();
        this.birthdate = student.getBirthdate();
        this.guardian = student.getGuardian().stream().map(GuardianDto::new).collect(Collectors.toList());
    }

    public static List<StudentDto> toStudentDto(List<Student> students) {
        return students.stream().map(StudentDto::new).collect(Collectors.toList());
    }

    

   

}