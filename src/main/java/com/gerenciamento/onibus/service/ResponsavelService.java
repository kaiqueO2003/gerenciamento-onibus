package com.gerenciamento.onibus.service;

import com.gerenciamento.onibus.model.dto.OnibusDTO;
import com.gerenciamento.onibus.model.dto.ResponsavelDTO;
import com.gerenciamento.onibus.model.entity.Onibus;
import com.gerenciamento.onibus.model.entity.Responsavel;
import com.gerenciamento.onibus.repository.OnibusRepository;
import com.gerenciamento.onibus.repository.ResponsavelRepository;
import com.gerenciamento.onibus.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ResponsavelService {
    @Autowired
    ResponsavelRepository repo;

    public List<Responsavel> findAll(){
        return repo.findAll();
    }

    public Responsavel findById(Long id){
        Optional<Responsavel> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Responsavel insert(Responsavel obj){
        return repo.save(obj);
    }

    public void delete (Long id){
        repo.deleteById(id);
    }

    public Responsavel update(Responsavel obj){
        Responsavel newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(Responsavel newObj, Responsavel obj) {
        newObj.setNome(obj.getNome());
        newObj.setCargo(obj.getCargo());

    }
    public Responsavel fromDTO(ResponsavelDTO objDto){
        return new Responsavel (objDto.getId(), objDto.getNome(), objDto.getCargo());
    }
}

