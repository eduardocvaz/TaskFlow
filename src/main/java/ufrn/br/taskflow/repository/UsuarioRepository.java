package ufrn.br.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.taskflow.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
