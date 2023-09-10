package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import ufrn.br.taskflow.core.base.BaseModel;

import java.util.Date;

@Entity
@Table(name = "comentario")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Comentario extends BaseModel {
    @Column
    @NotBlank(message = "O campo 'Texto' da entidade Comentario não pode ser vazio")
    private String texto;

    @Column
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @NotNull(message = "O campo 'Usuario' da entidade Comentario não pode ser nulo")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;
}
