package ufrn.br.taskflow.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.model.Equipe;
import ufrn.br.taskflow.repository.EquipeRepository;

import java.util.Optional;

@Service
public class EquipeService  extends BaseService<Equipe, EquipeRepository> {
    @Transactional
    public Equipe patchUpdate(Equipe model) {
        Optional<Equipe> modelDb = repository.findById(model.getId());

        if (modelDb.isPresent()) {
            Equipe modelPart = modelDb.get();
            modelPart.partialUpdate(model);
            return repository.save(modelPart);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }
}
