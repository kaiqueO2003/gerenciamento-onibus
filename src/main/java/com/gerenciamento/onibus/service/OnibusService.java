package com.gerenciamento.onibus.service;

import com.gerenciamento.onibus.OnibusApplication;
import com.gerenciamento.onibus.model.dto.OnibusDTO;
import com.gerenciamento.onibus.model.entity.Onibus;
import com.gerenciamento.onibus.repository.OnibusRepository;
import com.gerenciamento.onibus.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class OnibusService {
    @Autowired
    OnibusRepository repo;

    public List<Onibus> findAll(){
        return repo.findAll();
    }

    public Onibus findById(Long id){
        Optional<Onibus> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public Onibus insert(Onibus obj){
        return repo.save(obj);
    }

    public void delete (Long id){
        repo.deleteById(id);
    }

    public Onibus update(Onibus obj){
        Onibus newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(Onibus newObj, Onibus obj) {
        newObj.setPrefixo(obj.getPrefixo());
        newObj.setPlaca(obj.getPlaca());
        newObj.setDataUltimoAbastecimento(obj.getDataUltimoAbastecimento());
        newObj.setDataUltimaManutencao(obj.getDataUltimaManutencao());

    }
    public Onibus fromDTO(OnibusDTO objDto){
        return new Onibus (objDto.getId(), objDto.getPrefixo(), objDto.getPlaca(), objDto.getDataUltimoAbastecimento(), objDto.getDataUltimaManutencao() );
    }
}
