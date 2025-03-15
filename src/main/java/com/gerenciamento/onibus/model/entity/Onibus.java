package com.gerenciamento.onibus.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "onibus")
public class Onibus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prefixo;
    private String placa;
    private LocalDate dataUltimaManutencao;
    private LocalDate dataUltimoAbastecimento;

}
