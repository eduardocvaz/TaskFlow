package ufrn.br.taskflow.service;

import org.springframework.stereotype.Service;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.model.Projeto;
import ufrn.br.taskflow.repository.ProjetoRepository;

@Service
public class ProjetoService  extends BaseService<Projeto, ProjetoRepository> {
}
