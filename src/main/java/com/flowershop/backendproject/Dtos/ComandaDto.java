package com.flowershop.backendproject.Dtos;

import lombok.*;

import java.util.Set;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComandaDto {
    private Long id;
    private int numar_comanda;
    private double suma;
    //private Set<UserDto> id_user;
}
