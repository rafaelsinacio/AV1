package Rafael.Siqueira.Controller;

import Rafael.Siqueira.Models.Piloto;
import Rafael.Siqueira.Service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/piloto")
public class PilotoController {

    @Autowired
    private PilotoService pilotoService;

    // Listar todos os pilotos
    @GetMapping("/listar")
    public ResponseEntity<List<Piloto>> listarPilotos() {
        List<Piloto> pilotos = pilotoService.listar();
        return new ResponseEntity<>(pilotos, HttpStatus.OK);
    }

    // Criar um novo piloto
    @PostMapping("/criar")
    public ResponseEntity<Piloto> criarPiloto(@RequestBody Piloto piloto) {
        Piloto novoPiloto = pilotoService.criar(piloto);
        return new ResponseEntity<>(novoPiloto, HttpStatus.CREATED);
    }

    // Buscar piloto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Piloto> buscarPilotoPorId(@PathVariable Long id) {
        Piloto piloto = pilotoService.buscarPorId(id);
        if (piloto != null) {
            return new ResponseEntity<>(piloto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Deletar piloto por ID
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarPiloto(@PathVariable Long id) {
        try {
            pilotoService.deletar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
