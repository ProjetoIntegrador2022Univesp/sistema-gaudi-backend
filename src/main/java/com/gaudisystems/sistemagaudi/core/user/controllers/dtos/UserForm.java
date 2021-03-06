package com.gaudisystems.sistemagaudi.core.user.controllers.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gaudisystems.sistemagaudi.core.roles.UserRole;
import com.gaudisystems.sistemagaudi.core.user.models.UserModel;

import lombok.Getter;

@Getter
public class UserForm {
    @NotNull @NotBlank @Length(min = 3, max = 50)
    private String name;
    @NotNull @Email @Length(min = 3, max = 50)
    private String email;
    @NotNull @NotBlank @Length(min = 3, max = 50) 
    private String password;
    @NotNull
    private List<UserRole> userProfile = new ArrayList<>();

    public UserModel convert() {
        return new UserModel(name, email, password, userProfile);
    }
}

