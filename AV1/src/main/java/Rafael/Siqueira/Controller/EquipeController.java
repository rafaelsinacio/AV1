package Rafael.Siqueira.Controller;

import Rafael.Siqueira.Models.Equipe;
import Rafael.Siqueira.Service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipe")
public class EquipeController {

    @Autowired
    private EquipeService equipeService;

    // Listar todas as equipes
    @GetMapping("/listar")
    public ResponseEntity<List<Equipe>> listarEquipes() {
        List<Equipe> equipes = equipeService.list();
        return new ResponseEntity<>(equipes, HttpStatus.OK);
    }

    // Criar uma nova equipe
    @PostMapping("/criar")
    public ResponseEntity<Equipe> criarEquipe(@RequestBody Equipe equipe) {
        Equipe novaEquipe = equipeService.criar(equipe);
        return new ResponseEntity<>(novaEquipe, HttpStatus.CREATED);
    }

    // Buscar equipe por ID
    @GetMapping("/{id}")
    public ResponseEntity<Equipe> buscarEquipePorId(@PathVariable Long id) {
        Equipe equipe = equipeService.buscarPorId(id);
        if (equipe != null) {
            return new ResponseEntity<>(equipe, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarEquipe(@PathVariable Long id) {
        try {
            equipeService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
