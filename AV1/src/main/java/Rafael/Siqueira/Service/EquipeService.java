package Rafael.Siqueira.Service;

import Rafael.Siqueira.Models.Equipe;
import Rafael.Siqueira.Repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository equipeRepository;

    public List<Equipe> list() {
        return equipeRepository.findAll();
    }

    public Equipe criar(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Equipe buscarPorId(Long id) {
        Optional<Equipe> equipe = equipeRepository.findById(id);
        return equipe.orElse(null);
    }

    public void deletar(Long id) {
        equipeRepository.deleteById(id);
    }
}
