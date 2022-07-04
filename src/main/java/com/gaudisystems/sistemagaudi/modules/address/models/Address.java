package com.gaudisystems.sistemagaudi.modules.address.models;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Data;

@Entity
@Data
@Table(name = "addresses")
public class Address {

    static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipcode;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    public Address() {
    }

    public Address(String street, String number, String complement, String neighborhood, String city, String state, String zipcode, Student student) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.student = student;
    }

    
    
}

