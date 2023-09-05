package ufrn.br.taskflow.service;

import org.springframework.stereotype.Service;
import ufrn.br.taskflow.core.base.BaseService;
import ufrn.br.taskflow.model.Comentario;
import ufrn.br.taskflow.repository.ComentarioRepository;

@Service
public class ComentarioService  extends BaseService<Comentario, ComentarioRepository> {
}
