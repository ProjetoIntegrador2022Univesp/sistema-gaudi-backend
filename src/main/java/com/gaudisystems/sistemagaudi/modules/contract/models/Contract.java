package com.gaudisystems.sistemagaudi.modules.contract.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Data;

@Data
@Entity
@Table(name = "contracts")
public class Contract {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date startDate;
    private BigDecimal totalValue;
    private BigDecimal discountValue;
    private int parcelsAmount;
    private Date firstParcelDate;

    @ManyToOne
    private Student student;
    
    @ManyToOne
    @JsonBackReference
    private Course course;


    public Contract() {
    }

    public Contract(Date startDate, Student student, Course course, BigDecimal totalValue, BigDecimal discountValue, int parcelsAmount, Date firstParcelDate) {
        this.startDate = startDate;
        this.student = student;
        this.course = course;
        this.totalValue = totalValue;
        this.discountValue = discountValue;
        this.parcelsAmount = parcelsAmount;
        this.firstParcelDate = firstParcelDate;
    }
    
}

/* CREATE TABLE CONTRATO (
	ID_CONTRATO		INT NOT NULL,
	DATA			DATE,
	ID_ALUNO		INT,
	ID_CURSO		INT,
	VALORTOTAL		DECIMAL(10,2),
	VALORDESCONTO	DECIMAL(10,2),
	QTDEPARCELAS	INT,
	DATAINICIOPARCELA	DATE, */