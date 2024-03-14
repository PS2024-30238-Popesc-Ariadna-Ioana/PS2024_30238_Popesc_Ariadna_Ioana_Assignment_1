package com.flowershop.backendproject.Dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReduceriDto {
    private Long id;
    private int numar;
    private String perioada;
    private String tip;
}
