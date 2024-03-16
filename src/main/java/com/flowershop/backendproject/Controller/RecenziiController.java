package com.flowershop.backendproject.Controller;

import com.flowershop.backendproject.Dtos.RecenziiDto;
import com.flowershop.backendproject.Services.RecenziiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller-ul care gestioneaza operatiile legate de recenzii.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/recenzii")
public class RecenziiController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecenziiController.class);
    private final RecenziiService recenziiService;

    @Autowired
    public RecenziiController(RecenziiService recenziiService){
        this.recenziiService = recenziiService;
    }

    /**
     * Returneaza o lista cu toate recenziile din sistem.
     * @return Lista de DTO-uri pentru recenzii
     */
    @GetMapping()
    public ResponseEntity<List<RecenziiDto>> getRecenzii(){
        LOGGER.info("GET request received to fetch all the reviews.");
        List<RecenziiDto> dtos = recenziiService.getRecenzii();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    /**
     * Returneaza informatiile despre o recenzie specificata prin ID.
     * @param recenzieId ID-ul recenziei
     * @return DTO-ul recenziei sau un cod de eroare HTTP in cazul in care recenzia nu exista
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<RecenziiDto> getRecenziiById(@PathVariable("id") Long recenzieId) {
        LOGGER.info("GET request received to fetch review with ID: {}", recenzieId);
        try{
            RecenziiDto dto = recenziiService.findRecenziiById(recenzieId);
            LOGGER.info("The review with ID {} found in the database", recenzieId);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }catch(Exception e){
            LOGGER.error("The review with ID {} not found in the database", recenzieId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Insereaza o noua recenzie in sistem.
     * @param recenziiDto DTO-ul recenziei care urmeaza sa fie inserata
     * @return ID-ul recenziei inserate sau un cod de eroare HTTP in cazul unei probleme
     */
    @PostMapping()
    public ResponseEntity<Long> insert(@Validated @RequestBody RecenziiDto recenziiDto) {
        LOGGER.info("POST request received to insert a new review");
        Long recenziiId = recenziiService.insert(recenziiDto);
        LOGGER.info("The review with ID {} inserted into the database", recenziiId);
        return new ResponseEntity<>(recenziiId, HttpStatus.CREATED);
    }

    /**
     * Actualizeaza informatiile despre o recenzie existenta.
     * @param recenziiId ID-ul recenziei care urmeaza sa fie actualizata
     * @param recenziiDto DTO-ul cu noile informatii ale recenziei
     * @return Un cod de eroare HTTP in cazul in care actualizarea a esuat sau HTTP 200 OK daca a avut succes
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateComanda(@PathVariable("id") Long recenziiId, @Validated @RequestBody RecenziiDto recenziiDto) {
        LOGGER.info("PUT request received to update review with ID: {}", recenziiId);
        try {
            recenziiService.update(recenziiId, recenziiDto);
            LOGGER.info("The review with ID {} updated", recenziiId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to update the review with ID: {}", recenziiId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Sterge recenzia cu ID-ul specificat.
     * @param recenziiId ID-ul recenziei care urmeaza sa fie stearsa
     * @return Un cod de eroare HTTP in cazul in care stergerea a esuat sau HTTP 200 OK daca a avut succes
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteRecenzie(@PathVariable("id") Long recenziiId) {
        LOGGER.info("DELETE request received to delete the review with ID: {}", recenziiId);
        try {
            recenziiService.delete(recenziiId);
            LOGGER.info("The review with ID {} deleted", recenziiId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to delete the review with ID: {}", recenziiId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
