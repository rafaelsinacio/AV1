package Rafael.Siqueira.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Piloto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int idade;
    private String categoria;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;
}
