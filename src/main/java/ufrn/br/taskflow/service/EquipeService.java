package ufrn.br.taskflow.service;

import org.springframework.stereotype.Service;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.model.Equipe;
import ufrn.br.taskflow.repository.EquipeRepository;

@Service
public class EquipeService  extends BaseService<Equipe, EquipeRepository> {
}
