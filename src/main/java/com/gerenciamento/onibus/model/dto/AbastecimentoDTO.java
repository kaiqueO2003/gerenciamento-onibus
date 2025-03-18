package com.gerenciamento.onibus.model.dto;

import com.gerenciamento.onibus.model.entity.Abastecimento;
import com.gerenciamento.onibus.model.entity.Onibus;

import java.time.LocalDate;

public class AbastecimentoDTO {
    private Long id;
    private LocalDate dataAbastecimento;
    private Integer litros;
    private Long idOnibus;

    public AbastecimentoDTO(Abastecimento abastecimento) {
        this.id = abastecimento.getId();
        this.dataAbastecimento = abastecimento.getDataAbastecimento();
        this.litros = abastecimento.getLitros();
        this.idOnibus= abastecimento.getOnibus().getId();
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

    public Long getIdOnibus() {
        return idOnibus;
    }

    public void setIdOnibus(Long idOnibus) {
        this.idOnibus = idOnibus;
    }
}
