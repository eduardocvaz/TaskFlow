package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import ufrn.br.taskflow.core.base.BaseModel;

import java.util.Date;

@Entity
@Table(name = "comentario")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SQLDelete(sql = "UPDATE comentario SET deleted_at = CURRENT_TIMESTAMP WHERE id=?")
@Where(clause = "deleted_at is null")
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

    public void partialUpdate(Comentario c) {
        if(c.getTexto() != null){
            this.setTexto(c.getTexto());
        }
        if(c.getDataCriacao() != null){
            this.setDataCriacao(c.getDataCriacao());
        }
        if(c.getUsuario() != null){
            this.setUsuario(c.getUsuario());
        }
        if(c.getTarefa() != null){
            this.setTarefa(c.getTarefa());
        }
    }

}
