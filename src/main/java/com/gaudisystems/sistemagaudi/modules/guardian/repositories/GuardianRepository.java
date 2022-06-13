package com.gaudisystems.sistemagaudi.modules.guardian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gaudisystems.sistemagaudi.modules.guardian.models.Guardian;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {
}

