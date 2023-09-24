package ufrn.br.taskflow.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.taskflow.controller.FuncaoController;
import ufrn.br.taskflow.model.Funcao;
import ufrn.br.taskflow.model.Projeto;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class FuncaoResponseDTO extends RepresentationModel<FuncaoResponseDTO> {
    private Long id;
    private String nome;
    private String descricao;

    public void addLinks() {
        this.add(linkTo(FuncaoController.class).slash(id).withSelfRel());
        this.add(linkTo(FuncaoController.class).slash(id).withRel("delete"));
        this.add(linkTo(FuncaoController.class).withRel("allFuncoes"));
    }
}
