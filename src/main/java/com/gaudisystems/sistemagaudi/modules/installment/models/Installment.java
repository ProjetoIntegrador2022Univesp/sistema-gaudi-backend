package com.gaudisystems.sistemagaudi.modules.installment.models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;

import lombok.Data;

@Data
@Entity
public class Installment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private int installmentNumber;
    private BigDecimal installmentValue;
    private Date installmentDueDate;

    @Enumerated(EnumType.STRING)
    private InstallmentStatus status;

    @ManyToOne
    @JsonBackReference
    private Contract contract;

    public Installment() {
    }

    public Installment(String description, int installmentNumber, BigDecimal installmentValue, Date installmentDueDate,
            InstallmentStatus status, Contract contract) {

        this.description = description;
        this.installmentNumber = installmentNumber;
        this.installmentValue = installmentValue;
        this.installmentDueDate = installmentDueDate;
        this.status = status;
        this.contract = contract;
        
    }

    
}
