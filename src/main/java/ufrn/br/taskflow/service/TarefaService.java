package ufrn.br.taskflow.service;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.dto.TarefaResponseDTO;
import ufrn.br.taskflow.model.Tarefa;
import ufrn.br.taskflow.repository.TarefaRepository;

import java.util.Optional;

@Service
public class TarefaService  extends BaseService<Tarefa, TarefaRepository> {

    public Tarefa findById(Long id){
        Optional<Tarefa> tarefaBuscada = repository.findById(id);
        if(tarefaBuscada.isPresent()){
            return tarefaBuscada.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }

    @Transactional
    public Tarefa patchUpdate(Tarefa model) {
        Optional<Tarefa> modelDb = repository.findById(model.getId());

        if (modelDb.isPresent()) {
            Tarefa modelPart = modelDb.get();
            modelPart.partialUpdate(model);
            return repository.save(modelPart);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }
}
