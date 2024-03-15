package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

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

  //  @ManyToOne
  //  @JoinColumn(name = "id_user")
  //  private User user;
}
