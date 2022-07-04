package com.gaudisystems.sistemagaudi.modules.student.models.dtos;

import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;

@Getter
public class StudentGuardianDto {
    private String name;
    private String cpf;
    private String rg;
    private String birthdate;
    private String phone;

    public StudentGuardianDto(Student student) {
        this.name = student.getName();
        this.cpf = student.getCpf();
        this.rg = student.getRg();
        this.birthdate = student.getBirthdate();
        this.phone = student.getPhone();
       
    }
    
}
