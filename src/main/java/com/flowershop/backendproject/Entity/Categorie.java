package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clasa entitate care reprezinta o categorie in sistem.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categorie")
@Builder
@Entity
public class Categorie {

    /**
     * Identificatorul unic pentru categorie.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * Numele categoriei.
     */
    @Column(name = "nume", nullable = false)
    private String nume;
}
