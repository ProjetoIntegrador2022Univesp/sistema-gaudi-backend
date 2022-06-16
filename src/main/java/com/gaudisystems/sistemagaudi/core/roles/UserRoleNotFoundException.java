package com.gaudisystems.sistemagaudi.core.roles;

public class UserRoleNotFoundException extends RuntimeException {

    public UserRoleNotFoundException(Long id) {
        super("UserRole not found with id: " + id);
    }

}
