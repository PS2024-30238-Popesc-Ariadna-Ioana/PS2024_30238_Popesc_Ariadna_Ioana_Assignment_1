package com.flowershop.backendproject.Controller;

import com.flowershop.backendproject.Dtos.ProdusDto;
import com.flowershop.backendproject.Services.ProdusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller-ul care gestioneaza operatiile legate de produse.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/produs")
public class ProdusController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProdusController.class);
    private final ProdusService produsService;

    @Autowired
    public ProdusController(ProdusService produsService){
        this.produsService = produsService;
    }

    /**
     * Returneaza o lista cu toate produsele din sistem.
     * @return Lista de DTO-uri pentru produse
     */
    @GetMapping()
    public ResponseEntity<List<ProdusDto>> getProdus(){
        LOGGER.info("GET request received to fetch all products.");
        List<ProdusDto> dtos = produsService.getProdus();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    /**
     * Returneaza informatiile despre un produs specificat prin ID.
     * @param produsId ID-ul produsului
     * @return DTO-ul produsului sau un cod de eroare HTTP in cazul in care produsul nu exista
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdusDto> getProdusById(@PathVariable("id") Long produsId) {
        LOGGER.info("GET request received to fetch user with ID: {}", produsId);
        try{
            ProdusDto dto = produsService.findProdusById(produsId);
            LOGGER.info("Product with ID {} found in the database", produsId);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }catch(Exception e){
            LOGGER.error("Product with ID {} not found in the database", produsId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Insereaza un nou produs in sistem.
     * @param produsDto DTO-ul produsului care urmeaza sa fie inserat
     * @return ID-ul produsului inserat sau un cod de eroare HTTP in cazul unei probleme
     */
    @PostMapping()
    public ResponseEntity<Long> insert(@Validated @RequestBody ProdusDto produsDto) {
        LOGGER.info("POST request received to insert a new product");
        Long produsId = produsService.insert(produsDto);
        LOGGER.info("User with ID {} inserted into the database", produsId);
        return new ResponseEntity<>(produsId, HttpStatus.CREATED);
    }

    /**
     * Actualizeaza informatiile despre un produs existent.
     * @param produsId ID-ul produsului care urmeaza sa fie actualizat
     * @param produsDto DTO-ul cu noile informatii ale produsului
     * @return Un cod de eroare HTTP in cazul in care actualizarea a esuat sau HTTP 200 OK daca a avut succes
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateProdus(@PathVariable("id") Long produsId, @Validated @RequestBody ProdusDto produsDto) {
        LOGGER.info("PUT request received to update product with ID: {}", produsId);
        try {
            produsService.update(produsId, produsDto);
            LOGGER.info("Product with ID {} updated", produsId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to update product with ID: {}", produsId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Sterge produsul cu ID-ul specificat.
     * @param produsId ID-ul produsului care urmeaza sa fie sters
     * @return Un cod de eroare HTTP in cazul in care stergerea a esuat sau HTTP 200 OK daca a avut succes
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProdus(@PathVariable("id") Long produsId) {
        LOGGER.info("DELETE request received to delete user with ID: {}", produsId);
        try {
            produsService.delete(produsId);
            LOGGER.info("Product with ID {} deleted", produsId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to delete product with ID: {}", produsId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
