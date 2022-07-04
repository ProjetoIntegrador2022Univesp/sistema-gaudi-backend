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
    
    static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String phone;
    private String birthdate;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

     @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Guardian> guardians;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Classroom> classrooms;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Contract> contracts; 


    public Student() {
    }

    public Student(String name, String email, String cpf, String rg, String phone, String birthdate, List<Address> addresses) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.phone = phone;
        this.birthdate = birthdate;
        this.addresses = addresses;
    }

    public Student(String name, String email, String cpf, String rg, String phone, String birthdate, List<Address> addresses, List<Guardian> guardians, List<Classroom> classrooms, List<Contract> contracts) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.phone = phone;
        this.birthdate = birthdate;
        this.addresses = addresses;
        this.guardians = guardians;
        this.classrooms = classrooms;
        this.contracts = contracts;
    }
   
}