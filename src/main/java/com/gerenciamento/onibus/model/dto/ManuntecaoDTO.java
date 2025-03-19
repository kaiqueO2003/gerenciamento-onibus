package com.gerenciamento.onibus.model.dto;

import com.gerenciamento.onibus.model.entity.Abastecimento;
import com.gerenciamento.onibus.model.entity.Manutencao;

import java.time.LocalDate;

public class ManuntecaoDTO {
    private Long id;
    private LocalDate dataManutencao;
    private String descricaoMantutencao;
    private ResponsavelDTO responsavel;
    private OnibusDTO onibus;

    public ManuntecaoDTO(Manutencao manutencao) {
        this.id = manutencao.getId();
        this.dataManutencao = manutencao.getDataManutencao();
        this.descricaoMantutencao = manutencao.getDescricaoMantutencao();
        this.responsavel = new ResponsavelDTO(manutencao.getResponsavel());
        this.onibus = new OnibusDTO(manutencao.getOnibus());
    }
    public ManuntecaoDTO(){

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
