package com.gerenciamento.onibus.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "abastecimento")
public class Abastecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataAbastecimento;
    private Integer litros;
    @ManyToOne
    private Responsavel responsavel;
    @ManyToOne
    @JoinColumn(name = "onibus_id")
    private Onibus onibus;

    public Abastecimento(){

    }

    public Abastecimento(Long id, LocalDate dataAbastecimento, Integer litros, Responsavel responsavel, Onibus onibus) {
        this.id = id;
        this.dataAbastecimento = dataAbastecimento;
        this.litros = litros;
        this.responsavel = responsavel;
        this.onibus = onibus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(LocalDate dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public Integer getLitros() {
        return litros;
    }

    public void setLitros(Integer litros) {
        this.litros = litros;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Onibus getOnibus() {
        return onibus;
    }

    public void setOnibus(Onibus onibus) {
        this.onibus = onibus;
    }
}
