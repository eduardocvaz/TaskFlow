package ufrn.br.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.taskflow.model.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
