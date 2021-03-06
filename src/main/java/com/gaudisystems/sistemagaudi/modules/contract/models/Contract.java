package com.gaudisystems.sistemagaudi.modules.contract.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.gaudisystems.sistemagaudi.modules.courses.models.Course;
import com.gaudisystems.sistemagaudi.modules.installment.models.Installment;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Data;

@Entity
@Data
@Table(name = "contracts")

public class Contract {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date startDate;
    private BigDecimal totalValue;
    private BigDecimal discountValue;
    private int numberOfInstallments;
    private Date startInstallmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Student student;
    
    @ManyToOne
    private Course course;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private List<Installment> installments;


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

    public Contract(Date startDate, Student student, Course course, BigDecimal totalValue, BigDecimal discountValue, int numberOfInstallments, Date startInstallmentDate, List<Installment> installments) {
        this.startDate = startDate;
        this.totalValue = totalValue;
        this.discountValue = discountValue;
        this.numberOfInstallments = numberOfInstallments;
        this.startInstallmentDate = startInstallmentDate;
        this.student = student;
        this.course = course;
        this.installments = installments;
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