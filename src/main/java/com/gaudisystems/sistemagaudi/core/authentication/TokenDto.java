package com.gaudisystems.sistemagaudi.core.authentication;

import lombok.Getter;

@Getter
public class TokenDto {

    public TokenDto(String token, String string) {
        this.token = token;
        this.type = string;
    }

    private String token;
    private String type;

}
