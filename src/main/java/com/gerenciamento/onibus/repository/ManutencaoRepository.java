package com.gerenciamento.onibus.repository;

import com.gerenciamento.onibus.model.entity.Abastecimento;
import com.gerenciamento.onibus.model.entity.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManutencaoRepository extends JpaRepository<Manutencao,Long> {
}
