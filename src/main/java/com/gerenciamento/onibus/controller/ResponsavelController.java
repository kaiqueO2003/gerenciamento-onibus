package com.gerenciamento.onibus.controller;

import com.gerenciamento.onibus.model.dto.OnibusDTO;
import com.gerenciamento.onibus.model.dto.ResponsavelDTO;
import com.gerenciamento.onibus.model.entity.Onibus;
import com.gerenciamento.onibus.model.entity.Responsavel;
import com.gerenciamento.onibus.service.OnibusService;
import com.gerenciamento.onibus.service.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/responsavel")
public class ResponsavelController {
    @Autowired
    private ResponsavelService service;

    @GetMapping
    public ResponseEntity<List<ResponsavelDTO>> findAll(){
        List<Responsavel> list = service.findAll();
        List<ResponsavelDTO> listDto= list.stream().map(x-> new ResponsavelDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponsavelDTO> findById(@PathVariable Long id){
        Responsavel obj = service.findById(id);
        return ResponseEntity.ok().body(new ResponsavelDTO(obj));
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody ResponsavelDTO objDto){
        Responsavel obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@RequestBody ResponsavelDTO objDto, @PathVariable Long id){
        Responsavel obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
