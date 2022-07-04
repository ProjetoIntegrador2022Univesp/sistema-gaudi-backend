package com.gaudisystems.sistemagaudi.modules.contract.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;
import com.gaudisystems.sistemagaudi.modules.courses.dtos.CourseDto;
import com.gaudisystems.sistemagaudi.modules.student.models.dtos.StudentDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContractDto {

    private long id;
    private Date startDate;
    private StudentDto student;
    private CourseDto course;
    private BigDecimal totalValue;
    private BigDecimal discountValue;
    private int numberOfInstallments;
    private Date startInstallmentDate;

    public ContractDto(Contract contract) {

        CourseDto courseDto = new CourseDto(contract.getCourse());
        StudentDto studentDto = new StudentDto(contract.getStudent()); 

        this.id = contract.getId();
        this.startDate = contract.getStartDate();
        this.student = studentDto;
        this.course = courseDto;
        this.totalValue = contract.getTotalValue();
        this.discountValue = contract.getDiscountValue();
        this.numberOfInstallments = contract.getNumberOfInstallments();
        this.startInstallmentDate = contract.getStartInstallmentDate();

    }

    public static List<ContractDto> toContractDto (List<Contract> contracts) {
        return contracts.stream().map(ContractDto::new).collect(Collectors.toList());
    }

}
