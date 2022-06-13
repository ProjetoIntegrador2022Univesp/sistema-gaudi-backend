package com.gaudisystems.sistemagaudi.core.user.controllers.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gaudisystems.sistemagaudi.core.user.models.UserModel;
import com.gaudisystems.sistemagaudi.core.user.repositories.UserRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserForm {
        
    @NotNull @NotBlank @Length(min = 3, max = 50)
    private String name;
    @NotNull @Email @Length(min = 3, max = 50)
    private String email;

    public UserModel update(Long id, UserRepository userRepository) {
        UserModel user = userRepository.findById(id).get();
        if(name != null) user.setName(name);
        if(email != null) user.setEmail(email);
        return user;
    }
        
        

}
