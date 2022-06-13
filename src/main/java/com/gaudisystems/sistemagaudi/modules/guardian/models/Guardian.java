package com.gaudisystems.sistemagaudi.modules.guardian.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Data;

@Entity
@Data
public class Guardian {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private String rg;
    private String dateOfBirth;
    private String phone;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    public Guardian() {
    }

    public Guardian(String name, String cpf, String rg, String dateOfBirth, String phone) {
        this.name = name;
        this.cpf = cpf;
        this.rg = rg;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }


}
/* 
CREATE TABLE RESPONSAVEL (
	ID_RESPONSAVEL INT NOT NULL,
	NOME VARCHAR(50),
	CPF CHAR(14),
	RG  VARCHAR(15),
	NASCIMENTO DATE,
	CONSTRAINT PK_RESPONSAVEL PRIMARY KEY (ID_RESPONSAVEL)
); */
