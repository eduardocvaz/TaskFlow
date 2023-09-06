package ufrn.br.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ufrn.br.taskflow.core.base.BaseRepository;
import ufrn.br.taskflow.model.Projeto;

@Repository
public interface ProjetoRepository extends BaseRepository<Projeto> {
}
