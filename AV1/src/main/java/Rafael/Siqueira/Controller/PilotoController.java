package Rafael.Siqueira.Controller;

import Rafael.Siqueira.Models.piloto;
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

    @GetMapping("/listar")
    public List<piloto> listarPilotos() {
        return pilotoService.list();
    }

    @PostMapping("/criar")
    public ResponseEntity<piloto> criarPiloto(@RequestBody piloto piloto) {
        piloto criado = pilotoService.criar(piloto);
        return new ResponseEntity<>(criado, HttpStatus.CREATED);
    }
}
