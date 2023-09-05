package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import lombok.*;
import ufrn.br.taskflow.core.BaseModel;

import java.util.Date;

@Entity
@Table(name = "comentario")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Comentario extends BaseModel {
    @Column
    private String texto;

    @Column
    private Date dataCriacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;
}
