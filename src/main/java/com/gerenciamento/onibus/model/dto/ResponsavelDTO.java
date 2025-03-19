package com.gerenciamento.onibus.model.dto;

import com.gerenciamento.onibus.model.entity.Onibus;
import com.gerenciamento.onibus.model.entity.Responsavel;

import java.time.LocalDate;

public class ResponsavelDTO {
    private Long id;
    private String nome;
    private String cargo;

    public ResponsavelDTO(Responsavel responsavel) {
        this.id = responsavel.getId();
        this.nome = responsavel.getNome();
        this.cargo = responsavel.getCargo();

    }

    public ResponsavelDTO(){

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
}
