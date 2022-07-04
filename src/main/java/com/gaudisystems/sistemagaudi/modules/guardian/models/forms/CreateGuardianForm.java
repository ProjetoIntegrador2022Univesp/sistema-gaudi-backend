package com.gaudisystems.sistemagaudi.modules.guardian.models.forms;

import java.util.List;

import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;

@Getter
public class CreateGuardianForm {

    private String name;
    private String cpf;
    private String rg;
    private String dateOfBirth;
    private String phone;
    private List<Student> students;

    public Guardian toGuardian() {
        return new Guardian(name, cpf, rg, dateOfBirth, phone, students);
    }

}
