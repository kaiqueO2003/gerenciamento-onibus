package com.gerenciamento.onibus.service;

import com.gerenciamento.onibus.model.dto.AbastecimentoDTO;
import com.gerenciamento.onibus.model.entity.Abastecimento;
import com.gerenciamento.onibus.model.entity.Onibus;
import com.gerenciamento.onibus.model.entity.Responsavel;
import com.gerenciamento.onibus.repository.AbastecimentoRepository;
import com.gerenciamento.onibus.repository.OnibusRepository;
import com.gerenciamento.onibus.repository.ResponsavelRepository;
import com.gerenciamento.onibus.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbastecimentoService {

    @Autowired
    AbastecimentoRepository abastecimentoRepository;
    @Autowired
    OnibusRepository onibusRepository;
    @Autowired
    ResponsavelRepository responsavelRepository;


    public List<Abastecimento> findAll() {
        return abastecimentoRepository.findAll();
    }

    public Abastecimento findById(Long id) {
        Optional<Abastecimento> obj = abastecimentoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public void delete(Long id) {
        abastecimentoRepository.deleteById(id);
    }

    public void abastecer(AbastecimentoDTO abastecimentoDTO) {
        if (abastecimentoDTO.getResponsavel() != null && abastecimentoDTO.getResponsavel().getId() != null) {
            Long idResponsavel = abastecimentoDTO.getResponsavel().getId();
            Responsavel responsavel = responsavelRepository.findById(idResponsavel)
                    .orElseThrow(() -> new RuntimeException("Responsável não encontrado"));

            if (abastecimentoDTO.getOnibus() != null && abastecimentoDTO.getOnibus().getId() != null) {
                Long idOnibus = abastecimentoDTO.getOnibus().getId();
                Onibus onibus = onibusRepository.findById(idOnibus)
                        .orElseThrow(() -> new RuntimeException("Ônibus não encontrado"));

                Abastecimento abastecimento = new Abastecimento();
                abastecimento.setDataAbastecimento(abastecimentoDTO.getDataAbastecimento());
                abastecimento.setLitros(abastecimentoDTO.getLitros());
                abastecimento.setResponsavel(responsavel);
                abastecimento.setOnibus(onibus);
                abastecimentoRepository.save(abastecimento);
            } else {
                throw new RuntimeException("Ônibus não informado");
            }
        } else {
            throw new RuntimeException("Responsável não informado");
        }
    }
    public Abastecimento atualizarAbastecimento(Long id, AbastecimentoDTO abastecimentoDTO) {
        Abastecimento abastecimento = abastecimentoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Abastecimento não encontrado"));

        if (abastecimentoDTO.getDataAbastecimento() != null) {
            abastecimento.setDataAbastecimento(abastecimentoDTO.getDataAbastecimento());
        }
        if (abastecimentoDTO.getLitros() != null) {
            abastecimento.setLitros(abastecimentoDTO.getLitros());
        }
        if (abastecimentoDTO.getResponsavel() != null && abastecimentoDTO.getResponsavel().getId() != null) {
            Responsavel responsavel = responsavelRepository.findById(abastecimentoDTO.getResponsavel().getId())
                    .orElseThrow(() -> new RuntimeException("Responsável não encontrado"));
            abastecimento.setResponsavel(responsavel);
        }
        if (abastecimentoDTO.getOnibus() != null && abastecimentoDTO.getOnibus().getId() != null) {
            Onibus onibus = onibusRepository.findById(abastecimentoDTO.getOnibus().getId())
                    .orElseThrow(() -> new RuntimeException("Ônibus não encontrado"));
            abastecimento.setOnibus(onibus);
        }

        return abastecimentoRepository.save(abastecimento);
    }

}