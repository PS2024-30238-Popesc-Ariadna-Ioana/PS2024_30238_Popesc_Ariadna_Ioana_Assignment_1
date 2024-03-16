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

/**
 * Controller-ul care gestioneaza operatiile legate de categoriile de produse.
 */
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

    /**
     * Returneaza o lista cu toate categoriile de produse din sistem.
     * @return Lista de DTO-uri pentru categoriile de produse
     */
    @GetMapping()
    public ResponseEntity<List<CategorieDto>> getCategorie(){
        LOGGER.info("GET request received to fetch all categories.");
        List<CategorieDto> dtos = categorieService.getCategorie();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    /**
     * Returneaza informatiile despre o categorie specificata prin ID.
     * @param cateorieId ID-ul categoriei
     * @return DTO-ul categoriei sau un cod de eroare HTTP in cazul in care categoria nu exista
     */
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

    /**
     * Insereaza o noua categorie in sistem.
     * @param categorieDto DTO-ul categoriei care urmeaza sa fie inserata
     * @return ID-ul categoriei inserate sau un cod de eroare HTTP in cazul unei probleme
     */
    @PostMapping()
    public ResponseEntity<Long> insert(@Validated @RequestBody CategorieDto categorieDto) {
        LOGGER.info("POST request received to insert a new category");
        Long categorieId = categorieService.insert(categorieDto);
        LOGGER.info("Category with ID {} inserted into the database", categorieId);
        return new ResponseEntity<>(categorieId, HttpStatus.CREATED);
    }

    /**
     * Actualizeaza informatiile despre o categorie existenta.
     * @param categorieId ID-ul categoriei care urmeaza sa fie actualizata
     * @param categorieDto DTO-ul cu noile informatii ale categoriei
     * @return Un cod de eroare HTTP in cazul in care actualizarea a esuat sau HTTP 200 OK daca a avut succes
     */
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

    /**
     * Sterge categoria cu ID-ul specificat.
     * @param categorieId ID-ul categoriei care urmeaza sa fie stearsa
     * @return Un cod de eroare HTTP in cazul in care stergerea a esuat sau HTTP 200 OK daca a avut succes
     */
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
