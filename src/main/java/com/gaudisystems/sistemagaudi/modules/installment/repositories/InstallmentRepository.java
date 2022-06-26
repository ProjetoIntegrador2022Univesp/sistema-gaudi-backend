package com.gaudisystems.sistemagaudi.modules.installment.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaudisystems.sistemagaudi.modules.installment.models.Installment;

@Repository
public interface InstallmentRepository extends JpaRepository<Installment, Long> {

    Optional<List<Installment>> findByContractStudentId(long id);

}

    
