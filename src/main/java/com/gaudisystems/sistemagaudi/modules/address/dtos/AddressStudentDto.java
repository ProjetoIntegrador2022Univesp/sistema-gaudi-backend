package com.gaudisystems.sistemagaudi.modules.address.dtos;

import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.address.models.Address;

import lombok.Getter;


@Getter
public class AddressStudentDto {

    private long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipcode;

    public AddressStudentDto(Address address) {
        

        this.id = address.getId();
        this.street = address.getStreet();
        this.number = address.getNumber();
        this.complement = address.getComplement();
        this.neighborhood = address.getNeighborhood();
        this.city = address.getCity();
        this.state = address.getState();
        this.zipcode = address.getZipcode();
    }

    public static List<AddressStudentDto> toAddressDto(List<Address> addresses) {
        return addresses.stream().map(AddressStudentDto::new).collect(Collectors.toList());
    }
}
