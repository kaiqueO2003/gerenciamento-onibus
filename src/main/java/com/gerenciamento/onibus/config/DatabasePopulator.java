package com.gerenciamento.onibus.config;

import com.gerenciamento.onibus.model.entity.Onibus;
import com.gerenciamento.onibus.model.entity.Responsavel;
import com.gerenciamento.onibus.repository.OnibusRepository;
import com.gerenciamento.onibus.repository.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Component
public class DatabasePopulator implements CommandLineRunner {
@Autowired
OnibusRepository onibusRepository;
@Autowired
     ResponsavelRepository responsavelRepository;


    @Override
    public void run(String... args) {
        if (onibusRepository.count() == 0) { // Evita duplicação de registros
            List<Onibus> onibusList = List.of(
                    new Onibus(null, "ESCOLAR", "JSK-3665", LocalDate.of(2025, 2, 10), LocalDate.of(2025, 2, 15)),
                    new Onibus(null, "117", "EJY-3291", LocalDate.of(2025, 1, 20), LocalDate.of(2025, 1, 25)),
                    new Onibus(null, "147", "CUC-4423", LocalDate.of(2025, 3, 5), LocalDate.of(2025, 3, 10)),
                    new Onibus(null, "3", "DBC-6131", LocalDate.of(2025, 4, 12), LocalDate.of(2025, 4, 18))
            );

            onibusRepository.saveAll(onibusList);
            System.out.println("Ônibus inseridos no banco: " + onibusList);
        }

        Responsavel edmilson = new Responsavel(null, "Edimilson", "Encarregado");
        responsavelRepository.saveAll(Arrays.asList(edmilson));

    }
}