package com.gaudisystems.sistemagaudi.core.advices;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormErrorDto {
    private String field;
    private String error;

    public FormErrorDto(String field, String message) {
        this.field = field;
        this.error = message;
    }

}
