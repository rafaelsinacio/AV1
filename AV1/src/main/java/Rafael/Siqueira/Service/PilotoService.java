package Rafael.Siqueira.Service;

import Rafael.Siqueira.Models.Piloto;
import Rafael.Siqueira.Repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    public List<Piloto> listar() {
        return pilotoRepository.findAll();
    }

    public Piloto criar(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    public Piloto buscarPorId(Long id) {
        Optional<Piloto> piloto = pilotoRepository.findById(id);
        return piloto.orElse(null);
    }

    public void deletar(Long id) {
        pilotoRepository.deleteById(id);
    }
}
