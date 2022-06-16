package com.gaudisystems.sistemagaudi.core.user.controllers.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRole {
        
    @NotNull @NotBlank @Length(min = 1, max = 8)
    private long roleId;

    UpdateUserRole() {
    }

    public UpdateUserRole(long roleId) {
        this.roleId = roleId;
    }

}
