package com.gaudisystems.sistemagaudi.modules.address;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Data;

@Entity
@Data
@Table(name = "addresses")
public class AddressDto {

    private long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipcode;
    private Student student;

    public AddressDto(Address address) {
        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.complement = address.getComplement();
        this.neighborhood = address.getNeighborhood();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipcode = address.getZipcode();
        this.student = address.getStudent();
    }

    public static List<AddressDto> toAddressDto(List<Address> addresses) {
        return addresses.stream().map(AddressDto::new).collect(Collectors.toList());
    }
}
