package ufrn.br.taskflow.service;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.model.Usuario;
import ufrn.br.taskflow.repository.UsuarioRepository;

import java.util.Optional;

@Service
public class UsuarioService extends BaseService<Usuario, UsuarioRepository> {

    @Transactional
    public Usuario patchUpdate(Usuario model) {
        Optional<Usuario> modelDb = repository.findById(model.getId());

        if (modelDb.isPresent()) {
            Usuario modelPart = modelDb.get();
            modelPart.partialUpdate(model);
            return repository.save(modelPart);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }
}
