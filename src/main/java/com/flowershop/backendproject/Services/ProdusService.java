package com.flowershop.backendproject.Services;

import com.flowershop.backendproject.Dtos.Mappers.ProdusMapper;
import com.flowershop.backendproject.Dtos.ProdusDto;
import com.flowershop.backendproject.Entity.Produs;
import com.flowershop.backendproject.Repositories.ProdusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
/**
 * Clasa de serviciu care gestioneaza operatiunile legate de produse.
 */
public class ProdusService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProdusService.class);
    private final ProdusRepository produsRepository;

    @Autowired
    public ProdusService(ProdusRepository produsRepository) {
        this.produsRepository = produsRepository;
    }

    /**
     * Returneaza o lista de toate produsele.
     *
     * @return Lista de produse sub forma de ProdusDto
     */
    public List<ProdusDto> getProdus() {
        List<Produs> produsList = produsRepository.findAll();
        return produsList.stream()
                .map(ProdusMapper::toProdusDto)
                .collect(Collectors.toList());
    }

    /**
     * Gaseste un produs dupa ID.
     *
     * @param id ID-ul produsului
     * @return ProdusDto-ul asociat produsului gasit
     * @throws Exception daca produsul nu exista
     */
    public ProdusDto findProdusById(Long id) throws Exception {
        Optional<Produs> produsOptional = produsRepository.findById(id);
        if (!produsOptional.isPresent()) {
            LOGGER.error("Product with id {} not found in the database", id);
            throw new Exception("Product with id: " + id + " not found");
        }
        return ProdusMapper.toProdusDto(produsOptional.get());
    }

    /**
     * Insereaza un nou produs in baza de date.
     *
     * @param produsDto ProdusDto-ul produsului de inserat
     * @return ID-ul produsului inserat
     */
    public Long insert(ProdusDto produsDto) {
        Produs produs = ProdusMapper.toEntity(produsDto);
        produs = produsRepository.save(produs);
        LOGGER.debug("Product with id {} inserted into the database", produs.getId());
        return produs.getId();
    }

    /**
     * Actualizeaza informatiile unui produs.
     *
     * @param id ID-ul produsului de actualizat
     * @param produsDto ProdusDto-ul cu noile informatii ale produsului
     * @return ProdusDto-ul produsului actualizat
     * @throws Exception daca produsul nu exista
     */
    public ProdusDto update(Long id, ProdusDto produsDto) throws Exception {
        Optional<Produs> produsOptional = produsRepository.findById(id);
        if (produsOptional.isPresent()) {
            Produs produs = produsOptional.get();
            produs.setNume(produsDto.getNume());
            produs.setPret(produsDto.getPret());
            produs.setSezon(produsDto.getSezon());
            produs.setStoc(produsDto.getStoc());
            Produs modifProdus = produsRepository.save(produs);
            LOGGER.debug("Product with id {} updated", id);
            return ProdusMapper.toProdusDto(modifProdus);
        } else {
            LOGGER.error("Product with id {} not found in the database", id);
            throw new Exception("Product with id: " + id + " not found");
        }
    }

    /**
     * Sterge un produs din baza de date.
     *
     * @param id ID-ul produsului de sters
     * @throws Exception daca produsul nu exista
     */
    public void delete(Long id) throws Exception {
        Optional<Produs> optionalProdus = produsRepository.findById(id);
        if (optionalProdus.isPresent()) {
            produsRepository.deleteById(id);
            LOGGER.debug("Product with id {} deleted", id);
        } else {
            LOGGER.error("Product with id {} not found in the database", id);
            throw new Exception("Product with id: " + id + " not found");
        }
    }
}
