package ufrn.br.taskflow.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.taskflow.controller.UsuarioController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class UsuarioResponseDTO extends RepresentationModel<UsuarioResponseDTO> {
    private String id;
    private String nome;
    private String sobrenome;
    private String email;
    private Long equipe;
    private Long tarefa;

    public void addLinks() {
        this.add(linkTo(UsuarioController.class).slash(id).withSelfRel());
        this.add(linkTo(UsuarioController.class).slash(id).withRel("delete"));
        this.add(linkTo(UsuarioController.class).withRel("allUsuarios"));
    }
}
