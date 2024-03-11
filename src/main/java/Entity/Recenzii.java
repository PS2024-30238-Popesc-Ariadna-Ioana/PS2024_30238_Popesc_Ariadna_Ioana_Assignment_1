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
@Table(name = "recenzii")

public class Recenzii {
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String nume_utilizator;

    @Column(name = "name", nullable = false)
    private String recenzia;
}
