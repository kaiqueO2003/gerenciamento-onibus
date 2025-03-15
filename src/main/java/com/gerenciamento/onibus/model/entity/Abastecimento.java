package com.gerenciamento.onibus.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "abastecimento")
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAbastecimento;
    private Integer litros;
    private Responsavel responsavel;
}
