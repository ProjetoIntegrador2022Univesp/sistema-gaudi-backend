package com.gaudisystems.sistemagaudi.modules.guardian.controllers.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;

import lombok.Getter;

@Getter
public class GuardianDto {
    private String name;
    private String cpf;
    private String rg;
    private String dateOfBirth;
    private String phone;

    public GuardianDto(Guardian guardian) {
        this.name = guardian.getName();
        this.cpf = guardian.getCpf();
        this.rg = guardian.getRg();
        this.dateOfBirth = guardian.getDateOfBirth();
        this.phone = guardian.getPhone();
    }

    public static List<GuardianDto> toGuardianDto(List<Guardian> guardians) {
        return guardians.stream().map(GuardianDto::new).collect(Collectors.toList());
    }
}

