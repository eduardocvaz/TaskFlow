package ufrn.br.taskflow.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.model.Comentario;
import ufrn.br.taskflow.repository.ComentarioRepository;

import java.util.Optional;

@Service
public class ComentarioService  extends BaseService<Comentario, ComentarioRepository> {

    @Transactional
    public Comentario patchUpdate(Comentario model) {
        Optional<Comentario> modelDb = repository.findById(model.getId());

        if (modelDb.isPresent()) {
            Comentario modelPart = modelDb.get();
            modelPart.partialUpdate(model);
            return repository.save(modelPart);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }
}
