package com.gaudisystems.sistemagaudi.modules.student.models.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.address.dtos.AddressStudentDto;
import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.classrooms.dtos.ClassroomStudentDto;
import com.gaudisystems.sistemagaudi.modules.contract.dtos.ContractStudentDto;
import com.gaudisystems.sistemagaudi.modules.guardian.models.dtos.GuardianStudentDto;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDto {
    private long id;
    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String phone;
    private String birthdate;
    private List<AddressStudentDto> addresses;
    private List<GuardianStudentDto> guardians;
    private List<ClassroomStudentDto> classrooms;
    private List<ContractStudentDto> contracts; 

    public StudentDto(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.email = student.getEmail();
        this.cpf = student.getCpf();
        this.rg = student.getRg();
        this.phone = student.getPhone();
        this.birthdate = student.getBirthdate();

        if(student.getAddresses()!=null){
            List<Address> addresses = student.getAddresses();
            this.addresses = AddressStudentDto.toAddressDto(addresses);

        }

        if(student.getGuardians()!=null){
            this.guardians = GuardianStudentDto.toGuardianDto(student.getGuardians());
        }
        if(student.getClassrooms()!=null){
            this.classrooms = ClassroomStudentDto.toClassroomDto(student.getClassrooms());
        }
        if(student.getContracts()!=null){
            this.contracts = ContractStudentDto.toContractDto(student.getContracts());
        } 

    }

    public static List<StudentDto> toStudentDto(List<Student> students) {
        return students.stream().map(StudentDto::new).collect(Collectors.toList());
    }

    public static StudentDto toStudentDto(Student student) {
        return new StudentDto(student);
    }
}

