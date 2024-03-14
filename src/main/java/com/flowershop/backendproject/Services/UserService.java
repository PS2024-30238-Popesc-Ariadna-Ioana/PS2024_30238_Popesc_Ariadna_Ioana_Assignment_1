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
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> getUser() {
        List<User> userList = userRepository.findAll();
        return userList.stream()
                .map(UserMapper::toUserDto)
                .collect(Collectors.toList());
    }

    public UserDto findUserById(Long id) throws Exception {
        Optional<User> userOptional = userRepository.findById(id);
        if (!userOptional.isPresent()) {
            LOGGER.error("User with id {} not found in the database", id);
            throw new Exception("User with id: " + id + " not found");
        }
        return UserMapper.toUserDto(userOptional.get());
    }

    public Long insert(UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        user = userRepository.save(user);
        LOGGER.debug("User with id {} inserted into the database", user.getId());
        return user.getId();
    }

    public UserDto update(Long id, UserDto userDto) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setNume(userDto.getNume());
            user.setEmail(userDto.getEmail());
            user.setParola(userDto.getParola());
            user.setRol(userDto.getRol());
            User modifUser = userRepository.save(user);
            LOGGER.debug("User with id {} updated", id);
            return UserMapper.toUserDto(modifUser);
        } else {
            LOGGER.error("User with id {} not found in the database", id);
            throw new Exception("User with id: " + id + " not found");
        }
    }

    public void delete(Long id) throws Exception {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            userRepository.deleteById(id);
            LOGGER.debug("User with id {} deleted", id);
        } else {
            LOGGER.error("User with id {} not found in the database", id);
            throw new Exception("User with id: " + id + " not found");
        }
    }
}
