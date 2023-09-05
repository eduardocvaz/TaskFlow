package ufrn.br.taskflow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ufrn.br.taskflow.model.Usuario;
import ufrn.br.taskflow.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    UsuarioRepository repository;
    @Autowired
    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }

    public List<Usuario> listAll(){
        return repository.findAll();
    }

    public Usuario create(Usuario u){
        return repository.save(u);
    }

    public Usuario getById(Long id) {
        Optional<Usuario> u = repository.findById(id);

        if (u.isPresent()) {
            return u.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }

    public Usuario update(Usuario u){
        Optional<Usuario> buscado = repository.findById(u.getId());

        if (buscado.isPresent()) {
            return repository.save(u);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }

    public void delete(Long id){
        Optional<Usuario> buscado = repository.findById(id);

        if(buscado.isPresent()){
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }

    public Usuario patchUpdate(Usuario u){
        Optional<Usuario> buscado = repository.findById(u.getId());

        if(buscado.isPresent()){
            Usuario busca = buscado.get();
            busca.partialUpdate(u);
            return repository.save(busca);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }


}
