package com.gaudisystems.sistemagaudi.modules.student.models.forms;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.classrooms.models.Classroom;
import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;
import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;

@Getter
public class CreateStudentForm extends StudentForm  {
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
    private List<Address> addresses;
    private List<Guardian> guardians;
    private List<Classroom> classrooms;
    private List<Contract> contracts; 


    public Student toStudent() {

        Student student = new Student(name, email, cpf, rg, phone, birthdate, addresses, guardians, classrooms, contracts);
        if(student.getAddresses()!=null) student.getAddresses().forEach(address -> address.setStudent(student));
        if(student.getGuardians()!=null) {
            List<Student> students = new ArrayList<>();
            students.add(student);
            student.getGuardians().forEach(guardian -> guardian.setStudents(students));
        }
        return student;
    }

}
