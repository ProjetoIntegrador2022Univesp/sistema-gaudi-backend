package com.gaudisystems.sistemagaudi.modules.student.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gaudisystems.sistemagaudi.modules.address.models.Address;
import com.gaudisystems.sistemagaudi.modules.classrooms.models.Classroom;
import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;
import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;

import lombok.Data;

@Entity
@Data
@Table(name = "students")
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String phone;
    private String birthdate;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Guardian> guardian;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Classroom> classroom;

    @OneToMany(mappedBy = "student")
    private List<Contract> contract;


    public Student() {
    }

    public Student(String name, String email, String cpf, String rg, String phone, List<Address> addresses, String birthdate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.phone = phone;
        this.addresses = addresses;
        this.birthdate = birthdate;
    }

    public Student(String name, String email, String cpf, String rg, String phone, List<Address> addresses,
            String birthdate, List<Guardian> guardian) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.phone = phone;
        this.addresses = addresses;
        this.birthdate = birthdate;
        this.guardian = guardian;
    }
}