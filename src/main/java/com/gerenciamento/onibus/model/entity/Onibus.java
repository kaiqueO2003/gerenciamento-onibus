package com.gerenciamento.onibus.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "onibus")
public class Onibus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prefixo;
    private String placa;
    private LocalDate dataUltimaManutencao;
    private LocalDate dataUltimoAbastecimento;

    @OneToMany(mappedBy = "onibus")
    private List<Manutencao> manutencaos;

    @OneToMany(mappedBy = "onibus")
    private List<Abastecimento> abastecimentos;

    public Onibus(){

    }

    public Onibus(Long id, String prefixo, String placa, LocalDate dataUltimaManutencao, LocalDate dataUltimoAbastecimento) {
        this.id = id;
        this.prefixo = prefixo;
        this.placa = placa;
        this.dataUltimaManutencao = dataUltimaManutencao;
        this.dataUltimoAbastecimento = dataUltimoAbastecimento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrefixo() {
        return prefixo;
    }

    public void setPrefixo(String prefixo) {
        this.prefixo = prefixo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public LocalDate getDataUltimaManutencao() {
        return dataUltimaManutencao;
    }

    public void setDataUltimaManutencao(LocalDate dataUltimaManutencao) {
        this.dataUltimaManutencao = dataUltimaManutencao;
    }

    public LocalDate getDataUltimoAbastecimento() {
        return dataUltimoAbastecimento;
    }

    public void setDataUltimoAbastecimento(LocalDate dataUltimoAbastecimento) {
        this.dataUltimoAbastecimento = dataUltimoAbastecimento;
    }

    public List<Manutencao> getManutencaos() {
        return manutencaos;
    }

    public void setManutencaos(List<Manutencao> manutencaos) {
        this.manutencaos = manutencaos;
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public void setAbastecimentos(List<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }
}
