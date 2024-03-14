package com.flowershop.backendproject.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_db")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String nume;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "parola", nullable = false)
    private String parola;

    @Column(name = "rol", nullable = false)
    private String rol;

}
