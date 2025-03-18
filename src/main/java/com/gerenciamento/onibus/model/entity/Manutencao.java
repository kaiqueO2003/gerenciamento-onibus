package com.gerenciamento.onibus.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "manutencao")
public class Manutencao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataManutencao;
    private String descricaoMantutencao;
    @ManyToOne
    private Responsavel responsavel;
    @ManyToOne
    @JoinColumn(name = "onibus_id")
    private Onibus onibus;
    public Manutencao(){

    }
    public Manutencao(Long id, LocalDate dataManutencao, String descricaoMantutencao, Responsavel responsavel) {
        this.id = id;
        this.dataManutencao = dataManutencao;
        this.descricaoMantutencao = descricaoMantutencao;
        this.responsavel = responsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao(LocalDate dataManutencao) {
        this.dataManutencao = dataManutencao;
    }

    public String getDescricaoMantutencao() {
        return descricaoMantutencao;
    }

    public void setDescricaoMantutencao(String descricaoMantutencao) {
        this.descricaoMantutencao = descricaoMantutencao;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }
}
