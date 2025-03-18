package com.gerenciamento.onibus.controller;

import com.gerenciamento.onibus.model.dto.OnibusDTO;
import com.gerenciamento.onibus.model.entity.Onibus;
import com.gerenciamento.onibus.service.OnibusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value="/onibus")
public class OnibusController {
    @Autowired
    private OnibusService service;

    @GetMapping
    public ResponseEntity<List<OnibusDTO>> findAll(){
        List<Onibus> list = service.findAll();
        List<OnibusDTO> listDto= list.stream().map(x-> new OnibusDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OnibusDTO> findById(@PathVariable Long id){
        Onibus obj = service.findById(id);
        return ResponseEntity.ok().body(new OnibusDTO(obj));
    }
    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody OnibusDTO objDto){
        Onibus obj = service.fromDTO(objDto);
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
    public ResponseEntity<Void> update(@RequestBody OnibusDTO objDto, @PathVariable Long id){
        Onibus obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
