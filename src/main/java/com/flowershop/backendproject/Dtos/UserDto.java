package com.flowershop.backendproject.Dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String nume;
    private String email;
    private String parola;
    private String rol;
}
