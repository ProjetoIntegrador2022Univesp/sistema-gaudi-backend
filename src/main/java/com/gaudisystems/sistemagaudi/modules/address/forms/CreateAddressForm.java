package com.gaudisystems.sistemagaudi.modules.address.forms;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.NumberFormat;

import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;

@Getter
public class CreateAddressForm {

    @NotNull @Length(min = 1, max = 100)
    private String street;
    @NotNull @NumberFormat(style = NumberFormat.Style.NUMBER) @Length(min = 1, max = 10)
    private String number;
    @NotNull @Length(min = 1, max = 100)
    private String complement;
    @NotNull @Length(min = 1, max = 100)
    private String neighborhood;
    @NotNull @Length(min = 1, max = 100)
    private String city;
    @NotNull @Length(min = 1, max = 2)
    private String state;
    @NotNull @Length(min = 1, max = 10)
    private String zipcode;
    private long studentId;

    public Address create(Student student) {
        return new Address(street, number, complement, neighborhood, city, state, zipcode, student);
    }

}
