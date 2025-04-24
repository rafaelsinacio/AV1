package Rafael.Siqueira.Service;

import Rafael.Siqueira.Models.Equipe;
import Rafael.Siqueira.Repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipeService {

    @Autowired
    private EquipeRepository EquipeRepository;

    public List<Equipe> list() {
        return EquipeRepository.findAll();
    }

    public Equipe criar(Equipe equipe) {
        return EquipeRepository.save(equipe);
    }

    public void delete(Equipe equipe) {
        EquipeRepository.delete(equipe);
    }
}
