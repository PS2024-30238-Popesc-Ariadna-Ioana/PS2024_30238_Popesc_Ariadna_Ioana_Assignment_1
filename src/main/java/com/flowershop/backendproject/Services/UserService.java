package com.flowershop.backendproject.Services;

import com.flowershop.backendproject.Dtos.Mappers.UserMapper;
import com.flowershop.backendproject.Dtos.UserDto;
import com.flowershop.backendproject.Entity.User;
import com.flowershop.backendproject.Repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

/**
 * Clasa de serviciu care gestioneaza operatiile legate de utilizatori.
 */
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Returneaza o lista de toti utilizatorii.
     *
     * @return Lista de utilizatori sub forma de UserDto
     */
    public List<UserDto> getUser() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    /**
     * Gaseste un utilizator dupa ID.
     *
     * @param id ID-ul utilizatorului
     * @return UserDto-ul asociat utilizatorului gasit
     * @throws Exception daca utilizatorul nu exista
     */
    public UserDto findUserById(Long id) throws Exception {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            LOGGER.error("Utilizatorul cu ID-ul {} nu a fost gasit in baza de date", id);
            throw new Exception("Utilizatorul cu ID-ul: " + id + " nu a fost gasit");
        }
        return UserMapper.toUserDto(userOptional.get());
    }

    /**
     * Insereaza un nou utilizator in baza de date.
     *
     * @param userDto UserDto-ul utilizatorului de inserat
     * @return ID-ul utilizatorului inserat
     */
    public Long insert(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        user = userRepository.save(user);
        LOGGER.debug("Utilizatorul cu ID-ul {} a fost inserat in baza de date", user.getId());
        return user.getId();
    }

    /**
     * Actualizeaza informatiile unui utilizator.
     *
     * @param id ID-ul utilizatorului de actualizat
     * @param userDto UserDto-ul cu noile informatii ale utilizatorului
     * @return UserDto-ul utilizatorului actualizat
     * @throws Exception daca utilizatorul nu exista
     */
    public UserDto update(Long id, UserDto userDto) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setNume(userDto.getNume());
            user.setEmail(userDto.getEmail());
            user.setParola(userDto.getParola());
            user.setRol(userDto.getRol());
            User modifiedUser = userRepository.save(user);
            LOGGER.debug("Utilizatorul cu ID-ul {} a fost actualizat", id);
            return UserMapper.toUserDto(modifiedUser);
        } else {
            LOGGER.error("Utilizatorul cu ID-ul {} nu a fost gasit in baza de date", id);
            throw new Exception("Utilizatorul cu ID-ul: " + id + " nu a fost gasit");
        }
    }

    /**
     * Sterge un utilizator din baza de date.
     *
     * @param id ID-ul utilizatorului de sters
     * @throws Exception daca utilizatorul nu exista
     */
    public void delete(Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            LOGGER.debug("Utilizatorul cu ID-ul {} a fost sters", id);
        } else {
            LOGGER.error("Utilizatorul cu ID-ul {} nu a fost gasit in baza de date", id);
            throw new Exception("Utilizatorul cu ID-ul: " + id + " nu a fost gasit");
        }
    }
}
