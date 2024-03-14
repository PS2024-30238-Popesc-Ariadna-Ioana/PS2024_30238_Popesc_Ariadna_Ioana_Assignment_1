package com.flowershop.backendproject.Dtos.Mappers;

import com.flowershop.backendproject.Dtos.UserDto;
import com.flowershop.backendproject.Entity.User;

import lombok.*;

@Setter
@Getter

public class UserMapper {
    public static UserDto toUserDto(User user) {

        return UserDto.builder()
                      .id(user.getId())
                      .nume(user.getNume())
                      .email(user.getEmail())
                      .parola(user.getParola())
                      .rol(user.getRol())
                      .build();
    }

    public static User toEntity(UserDto userDto) {

        return  User.builder().nume(userDto.getNume())
                              .email(userDto.getEmail())
                              .parola(userDto.getParola())
                              .rol(userDto.getRol())
                              .build();
    }
}
