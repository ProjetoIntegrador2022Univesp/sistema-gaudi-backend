package com.gaudisystems.sistemagaudi.modules.guardian.models.forms;

import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;

import lombok.Getter;

@Getter
public class UpdateGuardianForm {

    private String name;
    private String cpf;
    private String rg;
    private String dateOfBirth;
    private String phone;

  

    public Guardian update(Guardian guardian) {
        if(name != null) guardian.setName(name);
        if(cpf != null) guardian.setCpf(cpf);
        if(rg != null) guardian.setRg(rg);
        if(dateOfBirth != null) guardian.setDateOfBirth(dateOfBirth);
        if(phone != null) guardian.setPhone(phone);
        return guardian;
    }

}
