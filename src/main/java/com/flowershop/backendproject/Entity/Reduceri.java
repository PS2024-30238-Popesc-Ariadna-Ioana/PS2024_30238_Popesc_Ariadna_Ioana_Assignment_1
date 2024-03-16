package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clasa entitate care reprezinta o reducere in sistem.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reduceri")
@Builder
@Entity
public class Reduceri {

    /**
     * Identificatorul unic pentru reducere.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Numele reducerei.
     */
    @Column(name = "nume", nullable = false)
    private String nume;

    /**
     * Perioada in care reducerea este aplicabila.
     */
    @Column(name = "perioada", nullable = false)
    private String perioada;

    /**
     * Procentul de reducere.
     */
    @Column(name = "procent", nullable = false)
    private double procent;

    // /**
    //  * Lista produselor asociate acestei reduceri.
    //  */
    // @Column(name = "reducere", nullable = false)
    // private List<Produs> id_produs;
}
