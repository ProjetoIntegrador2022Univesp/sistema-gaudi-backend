package com.gaudisystems.sistemagaudi.modules.contract.forms;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;
import com.gaudisystems.sistemagaudi.modules.courses.models.Course;
import com.gaudisystems.sistemagaudi.modules.student.models.Student;

import lombok.Getter;

@Getter
public class CreateContractForm {
    @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @NotNull 
    private long studentId;
    @NotNull
    private long courseId;
    @NotNull @DecimalMin("0.00") @DecimalMax("999999.99")
    private BigDecimal totalValue;
    @NotNull
    private BigDecimal discountValue;
    @NotNull @DecimalMin("1") @DecimalMax("999")
    private int numberOfInstallments;
    @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startInstallmentDate;


    public Contract toContract(Student student, Course course) {
        return new Contract(startDate, student, course, totalValue, discountValue, numberOfInstallments, startInstallmentDate);
    }

  

}
