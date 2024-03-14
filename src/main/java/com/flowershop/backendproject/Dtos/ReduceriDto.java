package com.flowershop.backendproject.Dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReduceriDto {
    private Long id;
    private String nume;
    private String perioada;
    private double procent;
}
