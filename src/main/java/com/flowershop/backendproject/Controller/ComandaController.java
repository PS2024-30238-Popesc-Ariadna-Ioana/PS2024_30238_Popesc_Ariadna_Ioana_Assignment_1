package com.flowershop.backendproject.Controller;

import com.flowershop.backendproject.Dtos.ComandaDto;
import com.flowershop.backendproject.Services.ComandaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller-ul care gestioneaza operatiile legate de comenzile de produse.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/comanda")
public class ComandaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CategorieController.class);
    private final ComandaService comandaService;

    @Autowired
    public ComandaController(ComandaService comandaService){
        this.comandaService = comandaService;
    }

    /**
     * Returneaza o lista cu toate comenzile de produse din sistem.
     * @return Lista de DTO-uri pentru comenzile de produse
     */
    @GetMapping()
    public ResponseEntity<List<ComandaDto>> getComanda(){
        LOGGER.info("GET request received to fetch all the orders.");
        List<ComandaDto> dtos = comandaService.getComanda();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    /**
     * Returneaza informatiile despre o comanda specificata prin ID.
     * @param comandaId ID-ul comenzii
     * @return DTO-ul comenzii sau un cod de eroare HTTP in cazul in care comanda nu exista
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ComandaDto> getCategorieById(@PathVariable("id") Long comandaId) {
        LOGGER.info("GET request received to fetch category with ID: {}", comandaId);
        try{
            ComandaDto dto = comandaService.findComandaById(comandaId);
            LOGGER.info("The order with ID {} found in the database", comandaId);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }catch(Exception e){
            LOGGER.error("The order with ID {} not found in the database", comandaId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Insereaza o noua comanda in sistem.
     * @param comandaDto DTO-ul comenzii care urmeaza sa fie inserata
     * @return ID-ul comenzii inserate sau un cod de eroare HTTP in cazul unei probleme
     */
    @PostMapping()
    public ResponseEntity<Long> insert(@Validated @RequestBody ComandaDto comandaDto) {
        LOGGER.info("POST request received to insert a new order");
        Long comandaId = comandaService.insert(comandaDto);
        LOGGER.info("The order with ID {} inserted into the database", comandaId);
        return new ResponseEntity<>(comandaId, HttpStatus.CREATED);
    }

    /**
     * Actualizeaza informatiile despre o comanda existenta.
     * @param comandaId ID-ul comenzii care urmeaza sa fie actualizata
     * @param comandaDto DTO-ul cu noile informatii ale comenzii
     * @return Un cod de eroare HTTP in cazul in care actualizarea a esuat sau HTTP 200 OK daca a avut succes
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateComanda(@PathVariable("id") Long comandaId, @Validated @RequestBody ComandaDto comandaDto) {
        LOGGER.info("PUT request received to update order with ID: {}", comandaId);
        try {
            comandaService.update(comandaId, comandaDto);
            LOGGER.info("The order with ID {} updated", comandaId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to update the order with ID: {}", comandaId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Sterge comanda cu ID-ul specificat.
     * @param comandaId ID-ul comenzii care urmeaza sa fie stearsa
     * @return Un cod de eroare HTTP in cazul in care stergerea a esuat sau HTTP 200 OK daca a avut succes
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteComanda(@PathVariable("id") Long comandaId) {
        LOGGER.info("DELETE request received to delete the order with ID: {}", comandaId);
        try {
            comandaService.delete(comandaId);
            LOGGER.info("The order with ID {} deleted", comandaId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to delete the order with ID: {}", comandaId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
