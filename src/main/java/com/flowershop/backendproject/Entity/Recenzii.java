package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clasa entitate care reprezinta o recenzie in sistem.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recenzii")
@Builder
@Entity
public class Recenzii {

    /**
     * Identificatorul unic pentru recenzie.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Numele utilizatorului.
     */
    @Column(name = "nume utilizator", nullable = false)
    private String nume_utilizator;

    /**
     * Textul recenziei.
     */
    @Column(name = "recenzia", nullable = false)
    private String recenzia;

    // /**
    //  * Lista produselor asociate acestei recenzii.
    //  */
    // @Column(name = "id produs", nullable = false)
    // private List<Produs> id_produs;
}
