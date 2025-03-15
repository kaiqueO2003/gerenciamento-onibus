package com.gerenciamento.onibus.repository;

import com.gerenciamento.onibus.model.entity.Onibus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OnibusRepository extends JpaRepository<Onibus,Long> {
}
