package ufrn.br.taskflow.core.base;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import ufrn.br.taskflow.model.Usuario;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

public abstract class BaseService <Model extends BaseModel, Repository extends BaseRepository<Model>> {

    @Autowired
    protected Repository repository;

    @SuppressWarnings("unchecked")
    protected Class<Model> getPersistentClass(){
        return (Class<Model>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     * Retorna lista de objetos
     */
    public List<Model> findAll() {
        return repository.findAll();
    }

    /**
     * Retorna um objeto de acordo com o seu id
     * @param id Id do objeto
     */
    public Model findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Adiciona novo registro
     * @param model
     * @return
     */
    @Transactional
    public Model insert(Model model) {
        return repository.save(model);
    }

    /**
     * Atualiza registro
     * @param model
     * @return
     */
    @Transactional
    public Model update(Model model) {
        Optional<Model> modelDb = repository.findById(model.getId());

        if (modelDb.isPresent()) {
            return repository.save(model);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }

    /**
     * Exclui registro
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        Optional<Model> model = repository.findById(id);

        if (model.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não encontrado");
        }
    }
}
