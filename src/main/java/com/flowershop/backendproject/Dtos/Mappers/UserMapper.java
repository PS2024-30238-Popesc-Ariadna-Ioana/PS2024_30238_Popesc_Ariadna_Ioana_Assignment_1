package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.UserDto;
import com.flowershop.backendproject.Entity.User;

import lombok.*;

@Setter
@Getter

/**
 * Clasa Mapper care realizeaza conversia intre entitatea User si UserDto.
 */
public class UserMapper {

    /**
     * Metoda statica pentru a converti un obiect de tip User in un obiect de tip UserDto.
     *
     * @param user Entitatea User care urmeaza sa fie convertita
     * @return Un obiect de tip UserDto convertit din entitatea User
     */
    public static UserDto toUserDto(User user) {

        return UserDto.builder()
                .id(user.getId())
                .nume(user.getNume())
                .email(user.getEmail())
                .parola(user.getParola())
                .rol(user.getRol())
                //.comanda(user.getComanda())
                .build();
    }

    /**
     * Metoda statica pentru a converti un obiect de tip UserDto in un obiect de tip User.
     *
     * @param userDto UserDto-ul care urmeaza sa fie convertit
     * @return Un obiect de tip User convertit din UserDto
     */
    public static User toEntity(UserDto userDto) {

        return  User.builder().nume(userDto.getNume())
                .email(userDto.getEmail())
                .parola(userDto.getParola())
                .rol(userDto.getRol())
                .build();
    }
}
