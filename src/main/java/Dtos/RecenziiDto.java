package Dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class RecenziiDto {
    private Long id;
    private String nume_utilizator;
    private String recenzia;
    private Long id_produs;
}
