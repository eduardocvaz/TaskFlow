package ufrn.br.taskflow.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.taskflow.controller.ProjetoController;
import ufrn.br.taskflow.controller.TarefaController;
import ufrn.br.taskflow.model.Projeto;

import java.util.Date;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class ProjetoResponseDTO extends RepresentationModel<ProjetoResponseDTO> {
    private Long id;
    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataTerminoPrevista;
    private Long gerenteId;

    public void addLinks() {
        this.add(linkTo(ProjetoController.class).slash(id).withSelfRel());
        this.add(linkTo(ProjetoController.class).slash(id).withRel("delete"));
        this.add(linkTo(ProjetoController.class).withRel("allProjetos"));
    }
}
