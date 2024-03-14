package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reduceri")
@Builder
@Entity
public class Reduceri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nume", nullable = false)
    private String nume;

    @Column(name = "perioada", nullable = false)
    private String perioada;

    @Column(name = "procent", nullable = false)
    private double procent;

    //@Column(name = "reducere", nullable = false)
    //private List<Produs> id_produs;
}
