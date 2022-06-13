package com.gaudisystems.sistemagaudi.core.user.controllers.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.core.user.models.UserModel;
import com.gaudisystems.sistemagaudi.core.utils.Role;

import lombok.Getter;

@Getter
public class UserDto{
    private Long id;
    private String name;
    private String email;
    private Role role;

    

    public UserDto(UserModel user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.role = user.getRole();

    }

    public static List<UserDto> toUserDto(List<UserModel> users) {
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }

}
