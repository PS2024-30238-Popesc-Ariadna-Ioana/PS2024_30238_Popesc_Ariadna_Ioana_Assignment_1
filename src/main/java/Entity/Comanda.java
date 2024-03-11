package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comanda")

public class Comanda {
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private int numar_comanda;

    @Column(name = "name", nullable = false)
    private double suma;
}
