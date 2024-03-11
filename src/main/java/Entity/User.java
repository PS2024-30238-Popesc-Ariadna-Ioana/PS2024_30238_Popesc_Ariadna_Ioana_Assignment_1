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
@Table(name = "user")

public class User {
    @Id
    private Long id;

    @Column(name = "name", nullable = false)
    private String nume;

    @Column(name = "name", nullable = false)
    private String email;

    @Column(name = "name", nullable = false)
    private String parola;

    @Column(name = "name", nullable = false)
    private String rol;

}
