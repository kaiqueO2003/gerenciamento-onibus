package com.gerenciamento.onibus.controller;

import com.gerenciamento.onibus.model.dto.AbastecimentoDTO;
import com.gerenciamento.onibus.model.dto.ManuntecaoDTO;
import com.gerenciamento.onibus.model.entity.Abastecimento;
import com.gerenciamento.onibus.model.entity.Manutencao;
import com.gerenciamento.onibus.service.AbastecimentoService;
import com.gerenciamento.onibus.service.ManutencaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/manutencao")
public class ManutencaoController {
    @Autowired
    private ManutencaoService service;

    @GetMapping
    public ResponseEntity<List<ManuntecaoDTO>> findAll(){
        List<Manutencao> list = service.findAll();
        List<ManuntecaoDTO> listDto= list.stream().map(x-> new ManuntecaoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ManuntecaoDTO> findById(@PathVariable Long id){
        Manutencao obj = service.findById(id);
        return ResponseEntity.ok().body(new ManuntecaoDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<Void> registrarManutencao(@RequestBody ManuntecaoDTO manuntecaoDTO) {
        service.registrarManutencao(manuntecaoDTO);
        return ResponseEntity.ok().build();
    }


}

