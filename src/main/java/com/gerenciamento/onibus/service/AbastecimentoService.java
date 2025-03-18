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

    public AbastecimentoDTO Abastecer(AbastecimentoDTO abastecimentoDTO) {
        Abastecimento abastecimento = new Abastecimento();
        abastecimento.setDataAbastecimento(abastecimentoDTO.getDataAbastecimento());
        abastecimento.setLitros(abastecimentoDTO.getLitros());
        Responsavel responsavel = responsavelRepository.findById(abastecimentoDTO.getIdResponsavel())
                .orElseThrow(() -> new RuntimeException("Responsável não encontrado"));
        Onibus onibus = onibusRepository.findById(abastecimentoDTO.getIdOnibus())
                .orElseThrow(() -> new RuntimeException("Ônibus não encontrado"));
        abastecimento.setResponsavel(responsavel);
        abastecimento.setOnibus(onibus);
        Abastecimento salvo = abastecimentoRepository.save(abastecimento);
        return new AbastecimentoDTO(salvo);
    }

    public AbastecimentoDTO update(AbastecimentoDTO abastecimentoDTO) {
        Abastecimento newObj = findById(abastecimentoDTO.getId());

        newObj.setDataAbastecimento(abastecimentoDTO.getDataAbastecimento());
        newObj.setLitros(abastecimentoDTO.getLitros());

        Responsavel responsavel = responsavelRepository.findById(abastecimentoDTO.getIdResponsavel())
                .orElseThrow(() -> new ObjectNotFoundException("Responsável com ID " + abastecimentoDTO.getIdResponsavel() + " não encontrado"));
        Onibus onibus = onibusRepository.findById(abastecimentoDTO.getIdOnibus())
                .orElseThrow(() -> new ObjectNotFoundException("Ônibus com ID " + abastecimentoDTO.getIdOnibus() + " não encontrado"));
        newObj.setResponsavel(responsavel);
        newObj.setOnibus(onibus);
        Abastecimento updatedAbastecimento = abastecimentoRepository.save(newObj);
        return new AbastecimentoDTO(updatedAbastecimento);
    }

    public Abastecimento fromDTO(AbastecimentoDTO abastecimentoDTO) {
        Responsavel responsavel = responsavelRepository.findById(abastecimentoDTO.getIdResponsavel())
                .orElseThrow(() -> new ObjectNotFoundException("Responsável com ID " + abastecimentoDTO.getIdResponsavel() + " não encontrado"));
        Onibus onibus = onibusRepository.findById(abastecimentoDTO.getIdOnibus())
                .orElseThrow(() -> new ObjectNotFoundException("Ônibus com ID " + abastecimentoDTO.getIdOnibus() + " não encontrado"));

        return new Abastecimento(
                abastecimentoDTO.getId(),
                abastecimentoDTO.getDataAbastecimento(),
                abastecimentoDTO.getLitros(),
                responsavel,
                onibus
        );
    }
}