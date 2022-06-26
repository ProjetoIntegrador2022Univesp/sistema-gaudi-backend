package com.gaudisystems.sistemagaudi.modules.contract.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;
import com.gaudisystems.sistemagaudi.modules.parcel.models.Installment;
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
    private int numberOfInstallments;
    private Date startInstallmentDate;

    @ManyToOne
    private Student student;
    
    @ManyToOne
    @JsonBackReference
    private Course course;

    @OneToMany(mappedBy = "contract", orphanRemoval = true)
    private List<Installment> parcels;


    public Contract() {
    }

    public Contract(Date startDate, Student student, Course course, BigDecimal totalValue, BigDecimal discountValue, int numberOfInstallments, Date startInstallmentDate) {
        this.startDate = startDate;
        this.totalValue = totalValue;
        this.discountValue = discountValue;
        this.numberOfInstallments = numberOfInstallments;
        this.startInstallmentDate = startInstallmentDate;
        this.student = student;
        this.course = course;
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