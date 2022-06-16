package com.gaudisystems.sistemagaudi.core.roles;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleForm {

    @NotNull @NotBlank @Length(min = 6, max = 20)
    private String name;



    public UserRole toUserRole() {
        return new UserRole(name);
    }

   
}
