package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * Clasa entitate care reprezinta un utilizator in sistem.
 */
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_db")
@Builder
public class User {

    /**
     * Identificatorul unic al utilizatorului.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Numele utilizatorului.
     */
    @Column(name = "name", nullable = false)
    private String nume;

    /**
     * Adresa de email a utilizatorului.
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Parola utilizatorului.
     */
    @Column(name = "parola", nullable = false)
    private String parola;

    /**
     * Rolul utilizatorului.
     */
    @Column(name = "rol", nullable = false)
    private String rol;

    // /**
    //  * Lista comenzilor efectuate de acest utilizator.
    //  */
    // @OneToMany(mappedBy = "user")
    // private List<Comanda> comanda;
}
