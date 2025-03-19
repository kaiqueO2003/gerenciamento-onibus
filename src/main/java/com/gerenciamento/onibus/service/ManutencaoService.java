package com.gerenciamento.onibus.service;

import com.gerenciamento.onibus.model.dto.AbastecimentoDTO;
import com.gerenciamento.onibus.model.dto.ManuntecaoDTO;
import com.gerenciamento.onibus.model.entity.Abastecimento;
import com.gerenciamento.onibus.model.entity.Manutencao;
import com.gerenciamento.onibus.model.entity.Onibus;
import com.gerenciamento.onibus.model.entity.Responsavel;
import com.gerenciamento.onibus.repository.ManutencaoRepository;
import com.gerenciamento.onibus.repository.OnibusRepository;
import com.gerenciamento.onibus.repository.ResponsavelRepository;
import com.gerenciamento.onibus.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ManutencaoService {

    @Autowired
    ManutencaoRepository manutencaoRepository;
    @Autowired
    OnibusRepository onibusRepository;
    @Autowired
    ResponsavelRepository responsavelRepository;


    public List<Manutencao> findAll() {
        return manutencaoRepository.findAll();
    }

    public Manutencao findById(Long id) {
        Optional<Manutencao> obj = manutencaoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public void delete(Long id) {
        manutencaoRepository.deleteById(id);
    }

    public void registrarManutencao(ManuntecaoDTO manuntecaoDTO) {
        if (manuntecaoDTO.getResponsavel() != null && manuntecaoDTO.getResponsavel().getId() != null) {
            Long idResponsavel = manuntecaoDTO.getResponsavel().getId();
            Responsavel responsavel = responsavelRepository.findById(idResponsavel)
                    .orElseThrow(() -> new RuntimeException("Responsável não encontrado"));

            if (manuntecaoDTO.getOnibus() != null && manuntecaoDTO.getOnibus().getId() != null) {
                Long idOnibus = manuntecaoDTO.getOnibus().getId();
                Onibus onibus = onibusRepository.findById(idOnibus)
                        .orElseThrow(() -> new RuntimeException("Ônibus não encontrado"));

                Manutencao manutencao = new Manutencao();
                manutencao.setDataManutencao(manuntecaoDTO.getDataManutencao());
                manutencao.setDescricaoMantutencao(manuntecaoDTO.getDescricaoMantutencao());
                manutencao.setResponsavel(responsavel);
                manutencao.setOnibus(onibus);
                manutencaoRepository.save(manutencao);
            } else {
                throw new RuntimeException("Ônibus não informado");
            }
        } else {
            throw new RuntimeException("Responsável não informado");
        }
    }
}


