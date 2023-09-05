package ufrn.br.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.taskflow.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
