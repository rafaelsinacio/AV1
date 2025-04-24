package Rafael.Siqueira.Models;

import Rafael.Siqueira.Models.piloto;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "equipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<piloto> pilotos;
}
