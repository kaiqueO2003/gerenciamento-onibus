package com.gerenciamento.onibus.model.dto;

import com.gerenciamento.onibus.model.entity.Abastecimento;
import com.gerenciamento.onibus.model.entity.Onibus;

import java.time.LocalDate;

public class AbastecimentoDTO {
    private Long id;
    private LocalDate dataAbastecimento;
    private Integer litros;
    private ResponsavelDTO responsavel;
    private OnibusDTO onibus;

    // Construtor que recebe a entidade e converte para DTO
    public AbastecimentoDTO(Abastecimento abastecimento) {
        this.id = abastecimento.getId();
        this.dataAbastecimento = abastecimento.getDataAbastecimento();
        this.litros = abastecimento.getLitros();
        this.responsavel = new ResponsavelDTO(abastecimento.getResponsavel());  // Converte a entidade Responsavel para DTO
        this.onibus = new OnibusDTO(abastecimento.getOnibus());
    }
    public AbastecimentoDTO(){

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

    public ResponsavelDTO getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(ResponsavelDTO responsavel) {
        this.responsavel = responsavel;
    }

    public OnibusDTO getOnibus() {
        return onibus;
    }

    public void setOnibus(OnibusDTO onibus) {
        this.onibus = onibus;
    }
}
