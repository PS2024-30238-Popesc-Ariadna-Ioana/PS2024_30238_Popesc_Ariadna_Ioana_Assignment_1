package com.flowershop.backendproject.Dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecenziiDto {
    private Long id;
    private String nume_utilizator;
    private String recenzia;
    private Long id_produs;
}
