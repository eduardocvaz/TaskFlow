package ufrn.br.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.taskflow.model.Comentario;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
