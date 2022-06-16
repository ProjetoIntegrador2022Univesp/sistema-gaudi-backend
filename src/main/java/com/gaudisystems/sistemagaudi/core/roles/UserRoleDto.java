package com.gaudisystems.sistemagaudi.core.roles;

import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDto {

    private Long id;
    private String name;

    public UserRoleDto(UserRole role) {
        this.name = role.getName();
        this.id = role.getId();
    }

    public static List<UserRoleDto> toUserRoleDto(List<UserRole> roles) {
        return roles.stream().map(UserRoleDto::new).collect(Collectors.toList());
    }
}
