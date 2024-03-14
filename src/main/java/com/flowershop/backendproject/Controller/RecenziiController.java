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

    @GetMapping()
    public ResponseEntity<List<RecenziiDto>> getRecenzii(){
        LOGGER.info("GET request received to fetch all the reviews.");
        List<RecenziiDto> dtos = recenziiService.getRecenzii();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

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

    @PostMapping()
    public ResponseEntity<Long> insert(@Validated @RequestBody RecenziiDto recenziiDto) {
        LOGGER.info("POST request received to insert a new review");
        Long recenziiId = recenziiService.insert(recenziiDto);
        LOGGER.info("The review with ID {} inserted into the database", recenziiId);
        return new ResponseEntity<>(recenziiId, HttpStatus.CREATED);
    }

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
