package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "recenzii")
@Builder
@Entity
public class Recenzii {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nume utilizator", nullable = false)
    private String nume_utilizator;

    @Column(name = "recenzia", nullable = false)
    private String recenzia;

    //@Column(name = "id produs", nullable = false)
    //private List<Produs> id_produs;
}
