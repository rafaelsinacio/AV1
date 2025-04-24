package Rafael.Siqueira.Models;

import Rafael.Siqueira.Models.Equipe;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String categoria;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}
