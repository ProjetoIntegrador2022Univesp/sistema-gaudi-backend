package com.gaudisystems.sistemagaudi.modules.courses;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "courses")
public class Course {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "course")
    private List<CourseModule> modules;
    private int minimalAge;

}

/* CREATE TABLE CURSO (
	ID_CURSO		INT NOT NULL,
	NOME			VARCHAR(30),
	DESCRICAO		VARCHAR(255),
	ID_PROFESSOR	INT,
	IDADEMINIMA		INT,
	CONSTRAINT PK_CURSO PRIMARY KEY(ID_CURSO),
	CONSTRAINT FK_CURSO_IDPROFESSOR FOREIGN KEY(ID_PROFESSOR) REFERENCES PROFESSOR(ID_PROFESSOR)
); */