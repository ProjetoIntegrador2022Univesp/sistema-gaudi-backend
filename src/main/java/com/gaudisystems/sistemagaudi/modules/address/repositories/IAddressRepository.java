package com.gaudisystems.sistemagaudi.modules.address.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gaudisystems.sistemagaudi.modules.address.models.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, Long> {

}

