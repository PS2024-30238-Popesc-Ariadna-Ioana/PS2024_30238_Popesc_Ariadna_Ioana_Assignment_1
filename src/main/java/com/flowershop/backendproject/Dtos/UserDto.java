package com.flowershop.backendproject.Dtos;

import lombok.*;

import java.util.Set;

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
    //private Set<ComandaDto> comanda;
}
