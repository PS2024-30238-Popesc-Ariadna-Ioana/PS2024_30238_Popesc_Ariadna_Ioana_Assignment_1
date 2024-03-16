package com.flowershop.backendproject.Dtos;

import lombok.*;

/**
 * Clasa DTO (Data Transfer Object) care reprezinta informatiile unei recenzii.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecenziiDto {

    /**
     * Identificatorul unic al recenziei.
     */
    private Long id;

    /**
     * Numele utilizatorului care a lasat recenzia.
     */
    private String nume_utilizator;

    /**
     * Textul recenziei.
     */
    private String recenzia;

    // /**
    //  * Identificatorul produsului la care este asociata recenzia.
    //  */
    // private Long id_produs;
}
