package com.flowershop.backendproject.Services;

import com.flowershop.backendproject.Dtos.Mappers.ReduceriMapper;
import com.flowershop.backendproject.Dtos.ReduceriDto;
import com.flowershop.backendproject.Entity.Reduceri;
import com.flowershop.backendproject.Repositories.ReduceriRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
/**
 * Clasa de serviciu care gestioneaza operatiunile legate de reduceri.
 */
public class ReduceriService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReduceriService.class);
    private final ReduceriRepository reduceriRepository;

    @Autowired
    public ReduceriService(ReduceriRepository reduceriRepository) {
        this.reduceriRepository = reduceriRepository;
    }

    /**
     * Returneaza o lista de toate reducerile.
     *
     * @return Lista de reduceri sub forma de ReduceriDto
     */
    public List<ReduceriDto> getReduceri() {
        List<Reduceri> reduceriList = reduceriRepository.findAll();
        return reduceriList.stream()
                .map(ReduceriMapper::toReduceriDto)
                .collect(Collectors.toList());
    }

    /**
     * Gaseste o reducere dupa ID.
     *
     * @param id ID-ul reducerii
     * @return ReduceriDto-ul asociat reducerii gasite
     * @throws Exception daca reducerea nu exista
     */
    public ReduceriDto finReduceriById(Long id) throws Exception {
        Optional<Reduceri> reduceriOptional = reduceriRepository.findById(id);
        if (!reduceriOptional.isPresent()) {
            LOGGER.error("The discount with id {} not found in the database", id);
            throw new Exception("The discount with id: " + id + " not found");
        }
        return ReduceriMapper.toReduceriDto(reduceriOptional.get());
    }

    /**
     * Insereaza o noua reducere in baza de date.
     *
     * @param reduceriDto ReduceriDto-ul reducerii de inserat
     * @return ID-ul reducerii inserate
     */
    public Long insert(ReduceriDto reduceriDto) {
        Reduceri reduceri = ReduceriMapper.toEntity(reduceriDto);
        reduceri = reduceriRepository.save(reduceri);
        LOGGER.debug("The discount with id {} inserted into the database", reduceri.getId());
        return reduceri.getId();
    }

    /**
     * Actualizeaza informatiile unei reduceri.
     *
     * @param id ID-ul reducerii de actualizat
     * @param reduceriDto ReduceriDto-ul cu noile informatii ale reducerii
     * @return ReduceriDto-ul reducerii actualizate
     * @throws Exception daca reducerea nu exista
     */
    public ReduceriDto update(Long id, ReduceriDto reduceriDto) throws Exception {
        Optional<Reduceri> reduceriOptional = reduceriRepository.findById(id);
        if (reduceriOptional.isPresent()) {
            Reduceri reduceri = reduceriOptional.get();
            reduceri.setNume(reduceriDto.getNume());
            reduceri.setPerioada(reduceriDto.getPerioada());
            reduceri.setProcent(reduceriDto.getProcent());
            Reduceri modifReduceri = reduceriRepository.save(reduceri);
            LOGGER.debug("The discount with id {} updated", id);
            return ReduceriMapper.toReduceriDto(modifReduceri);
        } else {
            LOGGER.error("The discount with id {} not found in the database", id);
            throw new Exception("The discount with id: " + id + " not found");
        }
    }

    /**
     * Sterge o reducere din baza de date.
     *
     * @param id ID-ul reducerii de sters
     * @throws Exception daca reducerea nu exista
     */
    public void delete(Long id) throws Exception {
        Optional<Reduceri> optionalReduceri = reduceriRepository.findById(id);
        if (optionalReduceri.isPresent()) {
            reduceriRepository.deleteById(id);
            LOGGER.debug("The discount with id {} deleted", id);
        } else {
            LOGGER.error("The discount with id {} not found in the database", id);
            throw new Exception("The discount with id: " + id + " not found");
        }
    }
}