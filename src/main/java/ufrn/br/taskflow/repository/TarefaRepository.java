package ufrn.br.taskflow.repository;

import org.springframework.stereotype.Repository;
import ufrn.br.taskflow.core.base.BaseRepository;
import ufrn.br.taskflow.model.Tarefa;

@Repository
public interface TarefaRepository extends BaseRepository<Tarefa> {
}
