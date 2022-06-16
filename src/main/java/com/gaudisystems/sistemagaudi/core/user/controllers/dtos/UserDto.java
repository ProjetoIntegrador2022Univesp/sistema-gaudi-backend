package com.gaudisystems.sistemagaudi.core.user.controllers.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.core.roles.UserRole;
import com.gaudisystems.sistemagaudi.core.user.models.UserModel;

import lombok.Getter;

@Getter
public class UserDto{
    private Long id;
    private String name;
    private String email;
    private List<UserRole> roles;

    

    public UserDto(UserModel user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.roles = user.getUserRoles();

    }

    public static List<UserDto> toUserDto(List<UserModel> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }

}
