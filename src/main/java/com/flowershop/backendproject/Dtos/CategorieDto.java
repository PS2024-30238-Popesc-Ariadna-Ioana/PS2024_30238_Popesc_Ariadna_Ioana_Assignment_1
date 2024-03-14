package com.flowershop.backendproject.Dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategorieDto {
    private Long id;
    private String nume;
    //private Long id_produs;
}
