package ufrn.br.taskflow.service;

import org.springframework.stereotype.Service;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.model.Funcao;
import ufrn.br.taskflow.repository.FuncaoRepository;

@Service
public class FuncaoService extends BaseService<Funcao, FuncaoRepository> {
}
