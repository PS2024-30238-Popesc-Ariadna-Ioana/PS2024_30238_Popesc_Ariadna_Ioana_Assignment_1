package com.flowershop.backendproject.Dtos;

import lombok.*;

/**
 * Clasa DTO (Data Transfer Object) care reprezinta informatiile unui produs.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdusDto {

    /**
     * Identificatorul unic al produsului.
     */
    private Long id;

    /**
     * Numele produsului.
     */
    private String nume;

    /**
     * Pretul produsului.
     */
    private double pret;

    /**
     * Sezonul produsului.
     */
    private String sezon;

    /**
     * Stocul disponibil pentru produs.
     */
    private int stoc;

    // /**
    //  * Identificatorul categoriei la care este asociat produsul.
    //  */
    // private Long id_categorie;
}
