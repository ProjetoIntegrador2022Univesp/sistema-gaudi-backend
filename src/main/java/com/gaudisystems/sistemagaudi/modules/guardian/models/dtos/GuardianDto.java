package com.gaudisystems.sistemagaudi.modules.guardian.models.dtos;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;
import com.gaudisystems.sistemagaudi.modules.student.models.dtos.StudentGuardianDto;

import lombok.Getter;

@Getter
public class GuardianDto {
    private String name;
    private String cpf;
    private String rg;
    private String dateOfBirth;
    private String phone;
    private List<StudentGuardianDto> students;

    public GuardianDto(Guardian guardian) {
        List<Student> students = guardian.getStudents();
        List<StudentGuardianDto> studentsDto = new ArrayList<>();

        for (Student student : students) {
            StudentGuardianDto studentGuardianDto = new StudentGuardianDto(student);
            studentsDto.add(studentGuardianDto);
        }

        this.name = guardian.getName();
        this.cpf = guardian.getCpf();
        this.rg = guardian.getRg();
        this.dateOfBirth = guardian.getDateOfBirth();
        this.phone = guardian.getPhone();
        this.students = studentsDto;
    }

    public static List<GuardianDto> toGuardianDto(List<Guardian> guardians) {
        return guardians.stream().map(GuardianDto::new).collect(Collectors.toList());
    }
}

