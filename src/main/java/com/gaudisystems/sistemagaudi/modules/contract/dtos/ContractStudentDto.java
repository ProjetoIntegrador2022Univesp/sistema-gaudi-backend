package com.gaudisystems.sistemagaudi.modules.contract.dtos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;
import com.gaudisystems.sistemagaudi.modules.courses.dtos.CourseDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractStudentDto {

    private long id;
    private Date startDate;
    private CourseDto course;
    private BigDecimal totalValue;
    private BigDecimal discountValue;
    private int numberOfInstallments;
    private Date startInstallmentDate;

    public ContractStudentDto(Contract contract) {

        CourseDto courseDto = new CourseDto(contract.getCourse());

        this.id = contract.getId();
        this.startDate = contract.getStartDate();
        this.course = courseDto;
        this.totalValue = contract.getTotalValue();
        this.discountValue = contract.getDiscountValue();
        this.numberOfInstallments = contract.getNumberOfInstallments();
        this.startInstallmentDate = contract.getStartInstallmentDate();

    }

    public static List<ContractStudentDto> toContractDto (List<Contract> contracts) {
        return contracts.stream().map(ContractStudentDto::new).collect(Collectors.toList());
    }

}
