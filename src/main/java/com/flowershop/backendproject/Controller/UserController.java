package com.flowershop.backendproject.Controller;

import com.flowershop.backendproject.Dtos.UserDto;
import com.flowershop.backendproject.Services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller-ul care gestioneaza operatiile legate de utilizatori.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    /**
     * Returneaza o lista cu toti utilizatorii din sistem.
     * @return Lista de DTO-uri pentru utilizatori
     */
    @GetMapping()
    public ResponseEntity<List<UserDto>> getUser(){
        LOGGER.info("GET request received to fetch all users");
        List<UserDto> dtos = userService.getUser();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    /**
     * Returneaza informatiile despre un utilizator specificat prin ID.
     * @param userId ID-ul utilizatorului
     * @return DTO-ul utilizatorului sau un cod de eroare HTTP in cazul in care utilizatorul nu exista
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId) {
        LOGGER.info("GET request received to fetch user with ID: {}", userId);
        try{
            UserDto dto = userService.findUserById(userId);
            LOGGER.info("User with ID {} found in the database", userId);
            return new ResponseEntity<>(dto, HttpStatus.OK);
        }catch(Exception e){
            LOGGER.error("User with ID {} not found in the database", userId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Insereaza un nou utilizator in sistem.
     * @param userDto DTO-ul utilizatorului care urmeaza sa fie inserat
     * @return ID-ul utilizatorului inserat sau un cod de eroare HTTP in cazul unei probleme
     */
    @PostMapping()
    public ResponseEntity<Long> insert(@Validated @RequestBody UserDto userDto) {
        LOGGER.info("POST request received to insert a new user");
        Long userID = userService.insert(userDto);
        LOGGER.info("User with ID {} inserted into the database", userID);
        return new ResponseEntity<>(userID, HttpStatus.CREATED);
    }

    /**
     * Actualizeaza informatiile despre un utilizator existent.
     * @param userId ID-ul utilizatorului care urmeaza sa fie actualizat
     * @param userDto DTO-ul cu noile informatii ale utilizatorului
     * @return Un cod de eroare HTTP in cazul in care actualizarea a esuat sau HTTP 200 OK daca a avut succes
     */
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") Long userId, @Validated @RequestBody UserDto userDto) {
        LOGGER.info("PUT request received to update user with ID: {}", userId);
        try {
            userService.update(userId, userDto);
            LOGGER.info("User with ID {} updated", userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to update user with ID: {}", userId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Sterge utilizatorul cu ID-ul specificat.
     * @param userId ID-ul utilizatorului care urmeaza sa fie sters
     * @return Un cod de eroare HTTP in cazul in care stergerea a esuat sau HTTP 200 OK daca a avut succes
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId) {
        LOGGER.info("DELETE request received to delete user with ID: {}", userId);
        try {
            userService.delete(userId);
            LOGGER.info("User with ID {} deleted", userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            LOGGER.error("Failed to delete user with ID: {}", userId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
