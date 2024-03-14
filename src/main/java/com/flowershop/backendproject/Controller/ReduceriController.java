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

    @GetMapping()
    public ResponseEntity<List<ReduceriDto>> getReduceri(){
        LOGGER.info("GET request received to fetch all the discounts.");
        List<ReduceriDto> dtos = reduceriService.getReduceri();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

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

    @PostMapping()
    public ResponseEntity<Long> insert(@Validated @RequestBody ReduceriDto reduceriDto) {
        LOGGER.info("POST request received to insert a new discount");
        Long reduceriId = reduceriService.insert(reduceriDto);
        LOGGER.info("The discount with ID {} inserted into the database", reduceriId);
        return new ResponseEntity<>(reduceriId, HttpStatus.CREATED);
    }

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
