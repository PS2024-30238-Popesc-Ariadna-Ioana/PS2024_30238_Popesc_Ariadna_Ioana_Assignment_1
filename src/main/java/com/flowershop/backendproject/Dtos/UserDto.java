package com.flowershop.backendproject.Dtos;

import lombok.*;

/**
 * Clasa DTO (Data Transfer Object) care reprezinta informațiile unui utilizator.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    /**
     * Identificatorul unic al utilizatorului.
     */
    private Long id;

    /**
     * Numele utilizatorului.
     */
    private String nume;

    /**
     * Adresa de email a utilizatorului.
     */
    private String email;

    /**
     * Parola utilizatorului.
     */
    private String parola;

    /**
     * Rolul utilizatorului.
     */
    private String rol;

    // /**
    //  * Setul de comenzi asociate acestui utilizator.
    //  */
    // private Set<ComandaDto> comanda;
}
