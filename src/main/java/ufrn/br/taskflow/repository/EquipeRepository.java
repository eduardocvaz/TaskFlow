package ufrn.br.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.taskflow.model.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
