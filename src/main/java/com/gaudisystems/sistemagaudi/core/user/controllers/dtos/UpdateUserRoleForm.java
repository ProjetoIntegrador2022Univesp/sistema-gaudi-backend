package com.gaudisystems.sistemagaudi.core.user.controllers.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.gaudisystems.sistemagaudi.core.roles.UserRole;
import com.gaudisystems.sistemagaudi.core.roles.UserRoleRepository;
import com.gaudisystems.sistemagaudi.core.user.models.UserModel;
import com.gaudisystems.sistemagaudi.core.user.repositories.UserRepository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRoleForm {
        
    @NotNull 
    private Long roleId;

    public UserModel update(Long id, UserRepository userRepository, UserRoleRepository userRoleRepository) {
        UserModel user = userRepository.findById(id).get();
        if(roleId != null){

            UserRole role = userRoleRepository.findById(roleId).get();
            List<UserRole> roles = new ArrayList<>();
            roles.add(role);
            user.setUserRoles(roles);
            return user;
        }else{
            return user;
        }
    }
}
