package com.gerenciamento.onibus.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "responsavel")
public class Responsavel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cargo;
    @OneToMany(mappedBy = "responsavel")
    private List<Abastecimento> abastecimentos;  // Lista de abastecimentos feitos pelo responsável

    @OneToMany(mappedBy = "responsavel")
    private List<Manutencao> manutencoes;

    public Responsavel(){

    }
    public Responsavel(Long id, String nome, String cargo, List<Abastecimento> abastecimentos, List<Manutencao> manutencoes) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.abastecimentos = abastecimentos;
        this.manutencoes = manutencoes;
    }

    public Responsavel(Long id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Abastecimento> getAbastecimentos() {
        return abastecimentos;
    }

    public void setAbastecimentos(List<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
    }

    public List<Manutencao> getManutencoes() {
        return manutencoes;
    }

    public void setManutencoes(List<Manutencao> manutencoes) {
        this.manutencoes = manutencoes;
    }
}
