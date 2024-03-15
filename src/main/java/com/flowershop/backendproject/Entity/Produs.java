package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produs")
@Builder
@Entity
public class Produs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "pret", nullable = false)
    private double pret;

    @Column(name = "sezon", nullable = false)
    private String sezon;

    @Column(name = "stoc", nullable = false)
    private int stoc;

    //@Column(name = "id categorie", nullable = false)
    //private List<Categorie> id_categorie;
}
