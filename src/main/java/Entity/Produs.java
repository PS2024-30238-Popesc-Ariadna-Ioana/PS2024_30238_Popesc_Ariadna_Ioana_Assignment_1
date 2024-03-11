package Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produs")

public class Produs {
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String nume;

    @Column(name = "name", nullable = false)
    private double pret;

    @Column(name = "name", nullable = false)
    private String sezon;

    @Column(name = "name", nullable = false)
    private int stoc;
}
