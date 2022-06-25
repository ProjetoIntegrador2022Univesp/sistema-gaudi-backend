package com.gaudisystems.sistemagaudi.modules.address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.NumberFormat;

import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Data;

@Entity
@Data
@Table(name = "addresses")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    private String zipcode;
    
    @ManyToOne
    private Student student;

    public Address() {
    }

    public Address(String street, String number, String complement, String neighborhood, String city, String state, String zipcode) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.neighborhood = neighborhood;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

  /*   CREATE TABLE ENDERECO(
	ID_ENDERECO	INT NOT NULL,
	TIPOLOGRADOURO	VARCHAR(10),
	NUMERO			VARCHAR(10),
	COMPLEMENTO		VARCHAR(25),
	BAIRRO			VARCHAR(30),
	CIDADE			VARCHAR(30),
	UF				CHAR(02),
	CEP				CHAR(10),
	PRIMARY KEY(ID_ENDERECO)
); */

    
}

