package ufrn.br.taskflow.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;
import ufrn.br.taskflow.controller.ComentarioController;
import ufrn.br.taskflow.model.Comentario;
import ufrn.br.taskflow.model.Equipe;

import java.util.Date;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Data
@NoArgsConstructor
public class ComentarioResponseDTO extends RepresentationModel<ComentarioResponseDTO> {
    private Long id;
    private String texto;
    private Date dataCriacao;
    private Long tarefaId;

    public void addLinks() {
        this.add(linkTo(ComentarioController.class).slash(id).withSelfRel());
        this.add(linkTo(ComentarioController.class).slash(id).withRel("delete"));
        this.add(linkTo(ComentarioController.class).withRel("allComentarios"));
    }
}
