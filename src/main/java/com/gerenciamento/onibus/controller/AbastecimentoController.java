package com.gerenciamento.onibus.controller;

import com.gerenciamento.onibus.model.dto.AbastecimentoDTO;
import com.gerenciamento.onibus.model.dto.OnibusDTO;
import com.gerenciamento.onibus.model.entity.Abastecimento;
import com.gerenciamento.onibus.model.entity.Onibus;
import com.gerenciamento.onibus.service.AbastecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/abastecimento")
public class AbastecimentoController {
    @Autowired
    private AbastecimentoService service;

    @GetMapping
    public ResponseEntity<List<AbastecimentoDTO>> findAll(){
        List<Abastecimento> list = service.findAll();
        List<AbastecimentoDTO> listDto= list.stream().map(x-> new AbastecimentoDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AbastecimentoDTO> findById(@PathVariable Long id){
        Abastecimento obj = service.findById(id);
        return ResponseEntity.ok().body(new AbastecimentoDTO(obj));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<AbastecimentoDTO> abastecer(@RequestBody AbastecimentoDTO abastecimentoDTO) {
        AbastecimentoDTO result = service.Abastecer(abastecimentoDTO);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AbastecimentoDTO> update(@RequestBody AbastecimentoDTO abastecimentoDTO, @PathVariable Long id) {
        abastecimentoDTO.setId(id);
        AbastecimentoDTO updatedDTO = service.update(abastecimentoDTO);
        return ResponseEntity.ok().body(updatedDTO);
    }

}
