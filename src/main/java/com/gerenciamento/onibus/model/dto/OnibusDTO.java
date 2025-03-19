package com.gerenciamento.onibus.model.dto;

import com.gerenciamento.onibus.model.entity.Onibus;
import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
public class OnibusDTO {
    private Long id;
    private String prefixo;
    private String placa;
    private LocalDate dataUltimaManutencao;
    private LocalDate dataUltimoAbastecimento;

    public OnibusDTO(Onibus onibus) {
        this.id = onibus.getId();
        this.prefixo = onibus.getPrefixo();
        this.placa = onibus.getPlaca();
        this.dataUltimaManutencao = onibus.getDataUltimaManutencao();
        this.dataUltimoAbastecimento = onibus.getDataUltimoAbastecimento();
    }

    public OnibusDTO(){

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
}
