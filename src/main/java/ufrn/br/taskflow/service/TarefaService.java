package ufrn.br.taskflow.service;

import org.springframework.stereotype.Service;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.model.Tarefa;
import ufrn.br.taskflow.repository.TarefaRepository;

@Service
public class TarefaService  extends BaseService<Tarefa, TarefaRepository> {
}
