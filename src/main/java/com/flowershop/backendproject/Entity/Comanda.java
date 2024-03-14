package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comanda")
@Builder
@Entity
public class Comanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numar", nullable = false)
    private int numar_comanda;

    @Column(name = "suma", nullable = false)
    private double suma;

    //@Column(name = "id_produs", nullable = false)
    //private List<Produs> id_produs;
}
