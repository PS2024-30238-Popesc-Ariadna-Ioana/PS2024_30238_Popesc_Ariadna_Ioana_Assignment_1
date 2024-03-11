package Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ProdusDto {
    private Long id;
    private String nume;
    private double pret;
    private String sezon;
    private int stoc;
}
