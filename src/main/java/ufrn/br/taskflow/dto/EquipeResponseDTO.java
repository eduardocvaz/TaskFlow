package ufrn.br.taskflow.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.taskflow.controller.EquipeController;
import ufrn.br.taskflow.model.Equipe;
import ufrn.br.taskflow.model.Funcao;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class EquipeResponseDTO extends RepresentationModel<EquipeResponseDTO> {
    private Long id;
    private String nome;
    private String descricao;

    public void addLinks() {
        this.add(linkTo(EquipeController.class).slash(id).withSelfRel());
        this.add(linkTo(EquipeController.class).slash(id).withRel("delete"));
        this.add(linkTo(EquipeController.class).withRel("allEquipes"));
    }
}
