package com.flowershop.backendproject.Controller;

import com.flowershop.backendproject.Dtos.CategorieDto;
import com.flowershop.backendproject.Services.CategorieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/categorie")
public class CategorieController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategorieController.class);
    private final CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService){
        this.categorieService = categorieService;
    }

    @GetMapping()
    public ResponseEntity<List<CategorieDto>> getCategorie(){
        LOGGER.info("GET request received to fetch all categories.");
        List<CategorieDto> dtos = categorieService.getCategorie();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategorieDto> getCategorieById(@PathVariable("id") Long cateorieId) {
        LOGGER.info("GET request received to fetch category with ID: {}", cateorieId);
        try{
            CategorieDto dto = categorieService.findCategorieById(cateorieId);
            LOGGER.info("Category with ID {} found in the database", cateorieId);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }catch(Exception e){
            LOGGER.error("Category with ID {} not found in the database", cateorieId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Long> insert(@Validated @RequestBody CategorieDto categorieDto) {
        LOGGER.info("POST request received to insert a new category");
        Long categorieId = categorieService.insert(categorieDto);
        LOGGER.info("Category with ID {} inserted into the database", categorieId);
        return new ResponseEntity<>(categorieId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateCategorie(@PathVariable("id") Long categorieId, @Validated @RequestBody CategorieDto categorieDto) {
        LOGGER.info("PUT request received to update product with ID: {}", categorieId);
        try {
            categorieService.update(categorieId, categorieDto);
            LOGGER.info("The category with ID {} updated", categorieId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to update the category with ID: {}", categorieId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategorie(@PathVariable("id") Long categorieId) {
        LOGGER.info("DELETE request received to delete user with ID: {}", categorieId);
        try {
            categorieService.delete(categorieId);
            LOGGER.info("The category with ID {} deleted", categorieId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to delete the category with ID: {}", categorieId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
