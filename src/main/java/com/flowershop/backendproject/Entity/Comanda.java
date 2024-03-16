package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clasa entitate care reprezinta o comanda in sistem.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comanda")
@Builder
@Entity
public class Comanda {

    /**
     * Identificatorul unic pentru comanda.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Numarul comenzii.
     */
    @Column(name = "numar", nullable = false)
    private int numar_comanda;

    /**
     * Suma totala a comenzii.
     */
    @Column(name = "suma", nullable = false)
    private double suma;

    // /**
    //  * Utilizatorul care a plasat aceasta comanda.
    //  */
    // @ManyToOne
    // @JoinColumn(name = "id_user")
    // private User user;
}
