package com.gaudisystems.sistemagaudi.modules.installment.controllers.forms;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;
import com.gaudisystems.sistemagaudi.modules.installment.models.Installment;
import com.gaudisystems.sistemagaudi.modules.installment.models.InstallmentStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateInstallmentForm {

    @Length(min = 3, max = 255)
    private String description;
    private int installmentNumber;
    private BigDecimal installmentValue;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date installmentDueDate;
    private InstallmentStatus status;
    private Contract contract;

    public UpdateInstallmentForm() {
    }

    public Installment update(Installment installment){
        if(description != null) installment.setDescription(description);
        if(installmentNumber != 0) installment.setInstallmentNumber(installmentNumber);
        if(installmentValue != null) installment.setInstallmentValue(installmentValue);
        if(installmentDueDate != null) installment.setInstallmentDueDate(installmentDueDate);
        if(status != null) installment.setStatus(status);
        if(contract != null) installment.setContract(contract);
        return installment;

    }




}
