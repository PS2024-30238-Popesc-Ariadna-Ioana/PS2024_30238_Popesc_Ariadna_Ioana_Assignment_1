package com.flowershop.backendproject.Dtos;

import lombok.*;

/**
 * Clasa DTO (Data Transfer Object) care reprezinta informatiile unei reduceri.
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReduceriDto {

    /**
     * Identificatorul unic al reducerii.
     */
    private Long id;

    /**
     * Numele reducerii.
     */
    private String nume;

    /**
     * Perioada in care reducera este valabila.
     */
    private String perioada;

    /**
     * Procentul reducerii.
     */
    private double procent;
}
