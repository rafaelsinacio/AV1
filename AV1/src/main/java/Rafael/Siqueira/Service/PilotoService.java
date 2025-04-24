package Rafael.Siqueira.Service;

import Rafael.Siqueira.Models.piloto;
import Rafael.Siqueira.Repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoService {

    @Autowired
    private PilotoRepository pilotoRepository;

    public List<piloto> list() {
        return pilotoRepository.findAll();
    }

    public piloto criar(piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    public void delete(piloto piloto) {
        pilotoRepository.delete(piloto);
    }
}
