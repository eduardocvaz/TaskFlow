package ufrn.br.taskflow.core.base;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

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
        Optional<Model> modelDb = repository.findById(id);

        if(modelDb.isPresent()){
            return modelDb.get();
        } else {
            throw new EntityNotFoundException("Não encontrado!");
        }

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
            throw new EntityNotFoundException("Não encontrado!");
        }
    }

    /**
     * Exclui registro
     * @param id
     */
    @Transactional
    public void delete(Long id) {
        Optional<Model> modelDb = repository.findById(id);

        if (modelDb.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Não encontrado!");
        }
    }
}
