package com.flowershop.backendproject.Dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdusDto {
    private Long id;
    private String nume;
    private double pret;
    private String sezon;
    private int stoc;
    private Long id_categorie;
}
