package ufrn.br.taskflow.core.base;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.lang.reflect.ParameterizedType;
import java.util.List;

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
     * Retorna lista de objetos de forma paginada
     */
    public Page<Model> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    /**
     * Retorna um objeto de acordo com o seu id
     * @param id Id do objeto
     */
    public Model findById(Long id) {
        Model model = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado!"));
        return model;
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
        repository.findById(model.getId()).orElseThrow(() -> new EntityNotFoundException("Não encontrado!"));
        return repository.save(model);
    }

    /**
     * Exclui registro
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Não encontrado!"));
        repository.deleteById(id);
    }

}
