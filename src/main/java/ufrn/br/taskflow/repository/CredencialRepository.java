package ufrn.br.taskflow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ufrn.br.taskflow.model.Credencial;

import java.util.Optional;

public interface CredencialRepository extends JpaRepository<Credencial, String> {
    // O JPA vai implementar esse metodo:
    Optional<Credencial> findByUsername(String username);
}
