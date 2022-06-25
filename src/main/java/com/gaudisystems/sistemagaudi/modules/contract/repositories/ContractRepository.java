package com.gaudisystems.sistemagaudi.modules.contract.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaudisystems.sistemagaudi.modules.contract.models.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long> {
    
}
