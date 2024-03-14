package com.flowershop.backendproject.Dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComandaDto {
    private Long id;
    private int numar_comanda;
    private double suma;
    //private Long id_produs;
}
