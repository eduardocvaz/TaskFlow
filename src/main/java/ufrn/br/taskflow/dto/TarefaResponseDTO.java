package ufrn.br.taskflow.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.taskflow.controller.TarefaController;
import ufrn.br.taskflow.controller.UsuarioController;

import java.util.Date;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class TarefaResponseDTO extends RepresentationModel<TarefaResponseDTO> {
    private Long id;
    private String nome;
    private String descricao;
    private String status;
    private Date dataInicio;
    private Date dataConclusaoPrevista;
    private Long projetoId;

    public void addLinks() {
        this.add(linkTo(TarefaController.class).slash(id).withSelfRel());
        this.add(linkTo(TarefaController.class).slash(id).withRel("delete"));
        this.add(linkTo(TarefaController.class).withRel("allTarefas"));
    }
}
