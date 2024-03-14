package com.flowershop.backendproject.Services;

import com.flowershop.backendproject.Dtos.CategorieDto;
import com.flowershop.backendproject.Dtos.Mappers.CategorieMapper;
import com.flowershop.backendproject.Entity.Categorie;
import com.flowershop.backendproject.Entity.Produs;
import com.flowershop.backendproject.Repositories.CategorieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategorieService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategorieService.class);
    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<CategorieDto> getCategorie() {
        List<Categorie> categorieList =  categorieRepository.findAll();
        return categorieList.stream()
                .map(CategorieMapper::toCategorieDto)
                .collect(Collectors.toList());
    }

    public CategorieDto findCategorieById(Long id) throws Exception {
        Optional<Categorie> categorieOptional = categorieRepository.findById(id);
        if (!categorieOptional.isPresent()) {
            LOGGER.error("The category with id {} not found in the database", id);
            throw new Exception("The category with id: " + id + " not found");
        }
        return CategorieMapper.toCategorieDto(categorieOptional.get());
    }

    public Long insert(CategorieDto categorieDto) {
        Categorie categorie = CategorieMapper.toEntity(categorieDto);
        categorie = categorieRepository.save(categorie);
        LOGGER.debug("The category with id {} inserted into the database", categorie.getId());
        return categorie.getId();
    }

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
