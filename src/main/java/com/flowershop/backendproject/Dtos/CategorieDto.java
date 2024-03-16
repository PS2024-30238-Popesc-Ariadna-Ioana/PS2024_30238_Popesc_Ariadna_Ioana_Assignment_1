package com.flowershop.backendproject.Dtos;

import lombok.*;

/**
 * Clasa DTO (Data Transfer Object) care reprezinta informatiile unei categorii.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategorieDto {

    /**
     * Identificatorul unic al categoriei.
     */
    private Long id;

    /**
     * Numele categoriei.
     */
    private String nume;

    // /**
    //  * Identificatorul produsului asociat acestei categorii.
    //  */
    // private Long id_produs;
}
