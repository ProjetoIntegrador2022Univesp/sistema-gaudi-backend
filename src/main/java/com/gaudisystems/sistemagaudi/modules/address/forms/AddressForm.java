package com.gaudisystems.sistemagaudi.modules.address.forms;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;

@Getter
public class AddressForm {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull @NotEmpty @Size(min = 3, max = 100)
    private String street;
    @NotNull @NotEmpty @Size(min = 1, max = 6) @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String number;
    @NotNull @NotEmpty @Size(min = 3, max = 25)
    private String complement;
    @NotNull @NotEmpty @Size(min = 3, max = 30)
    private String neighborhood;
    @NotNull @NotEmpty @Size(min = 3, max = 30)
    private String city;
    @NotNull @NotEmpty @Size(min = 2, max = 2)
    private String state;
    @NotNull @NotEmpty @Size(min = 10, max = 10)
    private String zipcode;
    private Student student;

    public Address toAddress() {
        return new Address(this.street, this.number, this.complement, this.neighborhood, this.city, this.state, this.zipcode, this.student);
    }
    
}

