package com.gaudisystems.sistemagaudi.modules.installment.controllers.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.contract.controllers.InstallmentContractDto;
import com.gaudisystems.sistemagaudi.modules.installment.models.Installment;
import com.gaudisystems.sistemagaudi.modules.installment.models.InstallmentStatus;

import lombok.Getter;

@Getter
public class InstallmentDto {

    private long id;
    private String description;
    private int installmentNumber;
    private BigDecimal installmentValue;
    private Date installmentDueDate;
    private InstallmentStatus status;
    private InstallmentContractDto contract;

    public InstallmentDto(Installment installment) {
        this.id = installment.getId();
        this.description = installment.getDescription();
        this.installmentNumber = installment.getInstallmentNumber();
        this.installmentValue = installment.getInstallmentValue();
        this.installmentDueDate = installment.getInstallmentDueDate();
        this.status = installment.getStatus();
        this.contract = new InstallmentContractDto(installment.getContract());
    }

    public static List<InstallmentDto> toInstallmentDto(List<Installment> installments) {
        return installments.stream().map(InstallmentDto::new).collect(Collectors.toList());
    }

}
