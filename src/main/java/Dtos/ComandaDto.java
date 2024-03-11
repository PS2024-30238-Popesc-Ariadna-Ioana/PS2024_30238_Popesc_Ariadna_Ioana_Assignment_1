package Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class ComandaDto {
    private Long id;
    private int numar_comanda;
    private Long id_produs;
    private double suma;
}
