package com.gaudisystems.sistemagaudi.modules.installment.controllers.forms;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;
import com.gaudisystems.sistemagaudi.modules.installment.models.Installment;
import com.gaudisystems.sistemagaudi.modules.installment.models.InstallmentStatus;

import lombok.Getter;

@Getter
public class CreateInstallmentForm {

    @NotNull @Length(min = 3, max = 255)
    private String description;
    @NotNull @Length(min = 1, max = 2)
    private int installmentNumber;
    @NotNull
    private BigDecimal installmentValue;
    @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date installmentDueDate;
    @NotNull @Length(min = 1, max = 20) @Enumerated(EnumType.STRING)
    private InstallmentStatus status;
    @NotNull 
    private long contractId;

    public CreateInstallmentForm() {
    }

    public static Installment toInstallment(CreateInstallmentForm installmentForm, Contract contract) {
        return new Installment(installmentForm.getDescription(), installmentForm.getInstallmentNumber(),
                installmentForm.getInstallmentValue(), installmentForm.getInstallmentDueDate(), installmentForm.getStatus(),
                contract);
    }
}
