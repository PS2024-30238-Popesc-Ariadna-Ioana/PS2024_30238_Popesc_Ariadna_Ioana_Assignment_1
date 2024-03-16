package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clasa entitate care reprezinta un produs in sistem.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produs")
@Builder
@Entity
public class Produs {

    /**
     * Identificatorul unic pentru produs.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Numele produsului.
     */
    @Column(name = "nume", nullable = false)
    private String nume;

    /**
     * Pretul produsului.
     */
    @Column(name = "pret", nullable = false)
    private double pret;

    /**
     * Sezonul produsului.
     */
    @Column(name = "sezon", nullable = false)
    private String sezon;

    /**
     * Stocul disponibil pentru produs.
     */
    @Column(name = "stoc", nullable = false)
    private int stoc;

    // /**
    //  * Lista categoriilor asociate acestui produs.
    //  */
    // @Column(name = "id categorie", nullable = false)
    // private List<Categorie> id_categorie;
}
