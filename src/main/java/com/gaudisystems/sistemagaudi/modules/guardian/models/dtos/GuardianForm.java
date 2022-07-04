package com.gaudisystems.sistemagaudi.modules.guardian.models.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;

import lombok.Getter;

@Getter
public class GuardianForm {
    @NotNull @NotBlank 
    private String name;
    @NotNull @NotBlank 
    private String cpf;
    @NotNull @NotBlank 
    private String rg;
    private String dateOfBirth;
    @NotNull @NotBlank 
    private String phone;

    public Guardian toGuardian() {
        Guardian guardian = new Guardian(name, cpf, rg, dateOfBirth, phone);

        return guardian;
    }

    public List<Guardian> toGuardian(List<Guardian> guardians) {
        List<Guardian> guardiansList = new ArrayList<>();
        for (Guardian guardian : guardians) {
            guardiansList.add(guardian);
        }
        return guardiansList;
    }
}
