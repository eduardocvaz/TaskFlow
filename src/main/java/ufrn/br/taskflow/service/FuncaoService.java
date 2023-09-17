package ufrn.br.taskflow.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.model.Funcao;
import ufrn.br.taskflow.repository.FuncaoRepository;

import java.util.Optional;

@Service
public class FuncaoService extends BaseService<Funcao, FuncaoRepository> {

    @Transactional
    public Funcao patchUpdate(Funcao model) {
        Optional<Funcao> modelDb = repository.findById(model.getId());

        if (modelDb.isPresent()) {
            Funcao modelPart = modelDb.get();
            modelPart.partialUpdate(model);
            return repository.save(modelPart);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }
}
