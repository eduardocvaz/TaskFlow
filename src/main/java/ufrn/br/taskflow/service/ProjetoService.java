package ufrn.br.taskflow.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.model.Projeto;
import ufrn.br.taskflow.model.Tarefa;
import ufrn.br.taskflow.repository.ProjetoRepository;

import java.util.Optional;

@Service
public class ProjetoService  extends BaseService<Projeto, ProjetoRepository> {

    @Transactional
    public Projeto patchUpdate(Projeto model) {
        Optional<Projeto> modelDb = repository.findById(model.getId());

        if (modelDb.isPresent()) {
            Projeto modelPart = modelDb.get();
            modelPart.partialUpdate(model);
            return repository.save(modelPart);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }
}
