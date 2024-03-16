package com.flowershop.backendproject.Controller;

import com.flowershop.backendproject.Dtos.ReduceriDto;
import com.flowershop.backendproject.Services.ReduceriService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller-ul care gestioneaza operatiile legate de reduceri.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/reduceri")
public class ReduceriController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReduceriController.class);
    private final ReduceriService reduceriService;

    @Autowired
    public ReduceriController(ReduceriService reduceriService){
        this.reduceriService = reduceriService;
    }

    /**
     * Returneaza o lista cu toate reducerile din sistem.
     * @return Lista de DTO-uri pentru reduceri
     */
    @GetMapping()
    public ResponseEntity<List<ReduceriDto>> getReduceri(){
        LOGGER.info("GET request received to fetch all the discounts.");
        List<ReduceriDto> dtos = reduceriService.getReduceri();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    /**
     * Returneaza informatiile despre o reducere specificata prin ID.
     * @param reducereId ID-ul reducerii
     * @return DTO-ul reducerii sau un cod de eroare HTTP in cazul in care reducerea nu exista
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ReduceriDto> getReduceriById(@PathVariable("id") Long reducereId) {
        LOGGER.info("GET request received to fetch discount with ID: {}", reducereId);
        try{
            ReduceriDto dto = reduceriService.finReduceriById(reducereId);
            LOGGER.info("The discount with ID {} found in the database", reducereId);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }catch(Exception e){
            LOGGER.error("The discount with ID {} not found in the database", reducereId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Insereaza o noua reducere in sistem.
     * @param reduceriDto DTO-ul reducerii care urmeaza sa fie inserata
     * @return ID-ul reducerii inserate sau un cod de eroare HTTP in cazul unei probleme
     */
    @PostMapping()
    public ResponseEntity<Long> insert(@Validated @RequestBody ReduceriDto reduceriDto) {
        LOGGER.info("POST request received to insert a new discount");
        Long reduceriId = reduceriService.insert(reduceriDto);
        LOGGER.info("The discount with ID {} inserted into the database", reduceriId);
        return new ResponseEntity<>(reduceriId, HttpStatus.CREATED);
    }

    /**
     * Actualizeaza informatiile despre o reducere existenta.
     * @param reduceriId ID-ul reducerii care urmeaza sa fie actualizata
     * @param reduceriDto DTO-ul cu noile informatii ale reducerii
     * @return Un cod de eroare HTTP in cazul in care actualizarea a esuat sau HTTP 200 OK daca a avut succes
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateReducere(@PathVariable("id") Long reduceriId, @Validated @RequestBody ReduceriDto reduceriDto) {
        LOGGER.info("PUT request received to update review with ID: {}", reduceriId);
        try {
            reduceriService.update(reduceriId, reduceriDto);
            LOGGER.info("The discount with ID {} updated", reduceriId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to update the discount with ID: {}", reduceriId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Sterge reducerea cu ID-ul specificat.
     * @param reducereId ID-ul reducerii care urmeaza sa fie stearsa
     * @return Un cod de eroare HTTP in cazul in care stergerea a esuat sau HTTP 200 OK daca a avut succes
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteReducere(@PathVariable("id") Long reducereId) {
        LOGGER.info("DELETE request received to delete the review with ID: {}", reducereId);
        try {
            reduceriService.delete(reducereId);
            LOGGER.info("The discount with ID {} deleted", reducereId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to delete the discount with ID: {}", reducereId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
