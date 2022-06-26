package com.gaudisystems.sistemagaudi.modules.student.controllers.forms;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;

@Getter
public class StudentForm {
    @NotNull @NotBlank 
    private String name;
    @NotNull @NotBlank 
    private String email;
    @NotNull @NotBlank 
    private String cpf;
    @NotNull @NotBlank
    private String rg;
    @NotNull @NotBlank 
    private String phone;
    @NotNull @NotBlank 
    private String birthdate;
    @NotNull
    private List<Guardian> guardian;
    private List<Address> addresses;


    public Student toStudent() {
        Student student = new Student(name, email, cpf, rg, phone, addresses, birthdate, guardian);
        return student;
    }

}
