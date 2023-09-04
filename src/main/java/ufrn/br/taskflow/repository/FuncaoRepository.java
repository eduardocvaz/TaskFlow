package ufrn.br.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.taskflow.model.Funcao;

public interface FuncaoRepository extends JpaRepository<Funcao, Long> {
}
