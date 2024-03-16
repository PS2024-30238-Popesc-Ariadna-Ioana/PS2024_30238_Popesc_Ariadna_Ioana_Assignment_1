package com.flowershop.backendproject.Services;

import com.flowershop.backendproject.Dtos.ComandaDto;
import com.flowershop.backendproject.Dtos.Mappers.ComandaMapper;
import com.flowershop.backendproject.Entity.Comanda;
import com.flowershop.backendproject.Repositories.ComandaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
/**
 * Clasa de serviciu care gestioneaza operatiile legate de comenzi.
 */
public class ComandaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ComandaService.class);
    private final ComandaRepository comandaRepository;

    @Autowired
    public ComandaService(ComandaRepository comandaRepository) {
        this.comandaRepository = comandaRepository;
    }

    /**
     * Returneaza o lista de toate comenzile.
     *
     * @return Lista de comenzi sub forma de ComandaDto
     */
    public List<ComandaDto> getComanda() {
        List<Comanda> comandaList = comandaRepository.findAll();
        return comandaList.stream()
                .map(ComandaMapper::toComandaDto)
                .collect(Collectors.toList());
    }

    /**
     * Gaseste o comanda dupa ID.
     *
     * @param id ID-ul comenzii
     * @return ComandaDto-ul asociat comenzii gasite
     * @throws Exception daca comanda nu exista
     */
    public ComandaDto findComandaById(Long id) throws Exception {
        Optional<Comanda> comandaOptional = comandaRepository.findById(id);
        if (!comandaOptional.isPresent()) {
            LOGGER.error("The order with id {} not found in the database", id);
            throw new Exception("The order with id: " + id + " not found");
        }
        return ComandaMapper.toComandaDto(comandaOptional.get());
    }

    /**
     * Insereaza o noua comanda in baza de date.
     *
     * @param comandaDto ComandaDto-ul comenzii de inserat
     * @return ID-ul comenzii inserate
     */
    public Long insert(ComandaDto comandaDto) {
        Comanda comanda = ComandaMapper.toEntity(comandaDto);
        comanda = comandaRepository.save(comanda);
        LOGGER.debug("The order with id {} inserted into the database", comanda.getId());
        return comanda.getId();
    }

    /**
     * Actualizeaza informatiile unei comenzi.
     *
     * @param id        ID-ul comenzii de actualizat
     * @param comandaDto ComandaDto-ul cu noile informatii ale comenzii
     * @return ComandaDto-ul comenzii actualizate
     * @throws Exception daca comanda nu exista
     */
    public ComandaDto update(Long id, ComandaDto comandaDto) throws Exception {
        Optional<Comanda> comandaOptional = comandaRepository.findById(id);
        if (comandaOptional.isPresent()) {
            Comanda comanda = comandaOptional.get();
            comanda.setNumar_comanda(comandaDto.getNumar_comanda());
            comanda.setSuma(comandaDto.getSuma());
            Comanda modifComanda = comandaRepository.save(comanda);
            LOGGER.debug("The order with id {} updated", id);
            return ComandaMapper.toComandaDto(modifComanda);
        } else {
            LOGGER.error("The order with id {} not found in the database", id);
            throw new Exception("The order with id: " + id + " not found");
        }
    }

    /**
     * Sterge o comanda din baza de date.
     *
     * @param id ID-ul comenzii de sters
     * @throws Exception daca comanda nu exista
     */
    public void delete(Long id) throws Exception {
        Optional<Comanda> optionalComanda = comandaRepository.findById(id);
        if (optionalComanda.isPresent()) {
            comandaRepository.deleteById(id);
            LOGGER.debug("The order with id {} deleted", id);
        } else {
            LOGGER.error("The order with id {} not found in the database", id);
            throw new Exception("The order with id: " + id + " not found");
        }
    }
}
