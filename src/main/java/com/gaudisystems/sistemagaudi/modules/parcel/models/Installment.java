package com.gaudisystems.sistemagaudi.modules.parcel.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;

import lombok.Data;

@Data
@Entity
public class Installment {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private int installmentNumber;
    private int installmentValue;
    private Date installmentDueDate;

    @OneToOne @Enumerated(EnumType.STRING)
    private InstallmentStatus status;

    @ManyToOne
    private Contract contract;

    
}
