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
@Table(name = "reduceri")

public class Reduceri {
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private int numar;

    @Column(name = "name", nullable = false)
    private String perioada;

    @Column(name = "name", nullable = false)
    private String tip;
}
