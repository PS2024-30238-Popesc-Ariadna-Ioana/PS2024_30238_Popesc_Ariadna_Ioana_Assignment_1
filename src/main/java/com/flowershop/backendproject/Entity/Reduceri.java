package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name = "numar", nullable = false)
    private int numar;

    @Column(name = "perioada", nullable = false)
    private String perioada;

    @Column(name = "tip", nullable = false)
    private String tip;

    //@Column(name = "reducere", nullable = false)
    //private List<Produs> id_produs;
}
