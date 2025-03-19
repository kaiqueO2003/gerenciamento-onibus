package com.gerenciamento.onibus.repository;

import com.gerenciamento.onibus.model.entity.Onibus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OnibusRepository extends JpaRepository<Onibus,Long> {
    Optional<Onibus> findByPlaca(String placa);

}
