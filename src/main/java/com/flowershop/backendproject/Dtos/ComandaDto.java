package com.flowershop.backendproject.Dtos;

import lombok.*;

/**
 * Clasa DTO (Data Transfer Object) care reprezinta informatiile unei comenzi.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComandaDto {

    /**
     * Identificatorul unic al comenzii.
     */
    private Long id;

    /**
     * Numarul comenzii.
     */
    private int numar_comanda;

    /**
     * Suma totala a comenzii.
     */
    private double suma;

    // /**
    //  * Setul de utilizatori asociat acestei comenzi.
    //  */
    // private Set<UserDto> id_user;
}
