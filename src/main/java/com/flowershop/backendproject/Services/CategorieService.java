package com.flowershop.backendproject.Services;

import com.flowershop.backendproject.Dtos.CategorieDto;
import com.flowershop.backendproject.Dtos.Mappers.CategorieMapper;
import com.flowershop.backendproject.Entity.Categorie;
import com.flowershop.backendproject.Repositories.CategorieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
/**
 * Clasa de serviciu care gestioneaza operatiile legate de categorii.
 */
public class CategorieService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategorieService.class);
    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    /**
     * Returneaza o lista de toate categoriile.
     *
     * @return Lista de categorii sub forma de CategorieDto
     */
    public List<CategorieDto> getCategorie() {
        List<Categorie> categorieList = categorieRepository.findAll();
        return categorieList.stream()
                .map(CategorieMapper::toCategorieDto)
                .collect(Collectors.toList());
    }

    /**
     * Gaseste o categorie dupa ID.
     *
     * @param id ID-ul categoriei
     * @return CategorieDto-ul asociat categoriei gasite
     * @throws Exception daca categoria nu exista
     */
    public CategorieDto findCategorieById(Long id) throws Exception {
        Optional<Categorie> categorieOptional = categorieRepository.findById(id);
        if (!categorieOptional.isPresent()) {
            LOGGER.error("The category with id {} not found in the database", id);
            throw new Exception("The category with id: " + id + " not found");
        }
        return CategorieMapper.toCategorieDto(categorieOptional.get());
    }

    /**
     * Insereaza o noua categorie in baza de date.
     *
     * @param categorieDto CategorieDto-ul categoriei de inserat
     * @return ID-ul categoriei inserate
     */
    public Long insert(CategorieDto categorieDto) {
        Categorie categorie = CategorieMapper.toEntity(categorieDto);
        categorie = categorieRepository.save(categorie);
        LOGGER.debug("The category with id {} inserted into the database", categorie.getId());
        return categorie.getId();
    }

    /**
     * Actualizeaza informatiile unei categorii.
     *
     * @param id           ID-ul categoriei de actualizat
     * @param categorieDto CategorieDto-ul cu noile informatii ale categoriei
     * @return CategorieDto-ul categoriei actualizate
     * @throws Exception daca categoria nu exista
     */
    public CategorieDto update(Long id, CategorieDto categorieDto) throws Exception {
        Optional<Categorie> categorieOptional = categorieRepository.findById(id);
        if (categorieOptional.isPresent()) {
            Categorie categorie = categorieOptional.get();
            categorie.setNume(categorieDto.getNume());
            Categorie modifCategorie = categorieRepository.save(categorie);
            LOGGER.debug("The category with id {} updated", id);
            return CategorieMapper.toCategorieDto(modifCategorie);
        } else {
            LOGGER.error("The category with id {} not found in the database", id);
            throw new Exception("Product with id: " + id + " not found");
        }
    }

    /**
     * Sterge o categorie din baza de date.
     *
     * @param id ID-ul categoriei de sters
     * @throws Exception daca categoria nu exista
     */
    public void delete(Long id) throws Exception {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if (optionalCategorie.isPresent()) {
            categorieRepository.deleteById(id);
            LOGGER.debug("The category with id {} deleted", id);
        } else {
            LOGGER.error("The category with id {} not found in the database", id);
            throw new Exception("The category with id: " + id + " not found");
        }
    }
}
