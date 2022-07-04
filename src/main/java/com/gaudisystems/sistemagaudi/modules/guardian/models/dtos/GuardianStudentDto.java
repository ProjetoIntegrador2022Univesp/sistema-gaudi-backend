package com.gaudisystems.sistemagaudi.modules.guardian.models.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;

import lombok.Getter;

@Getter
public class GuardianStudentDto {
    private String name;
    private String cpf;
    private String rg;
    private String dateOfBirth;
    private String phone;

    public GuardianStudentDto(Guardian guardian) {
        this.name = guardian.getName();
        this.cpf = guardian.getCpf();
        this.rg = guardian.getRg();
        this.dateOfBirth = guardian.getDateOfBirth();
        this.phone = guardian.getPhone();
    }

    public static List<GuardianStudentDto> toGuardianDto(List<Guardian> guardians) {
        return guardians.stream().map(GuardianStudentDto::new).collect(Collectors.toList());
    }
}

