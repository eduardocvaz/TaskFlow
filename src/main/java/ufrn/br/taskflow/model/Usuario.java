package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import ufrn.br.taskflow.core.base.BaseModel;

@Entity
@Table(name = "usuario")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@SQLDelete(sql = "UPDATE usuario SET deleted_at = CURRENT_TIMESTAMP WHERE id=?")
@Where(clause = "deleted_at is null")
public class Usuario extends BaseModel {
    @Column
    @NotBlank(message = "O campo 'Nome' da entidade Usuario não pode ser vazio")
    private String nome;

    @Column
    @NotBlank(message = "O campo 'Sobrenome' da entidade Usuario não pode ser vazio")
    private String sobrenome;

    @Column
    @Email
    private String email;

    @Column
    @NotBlank(message = "O campo 'Senha' da entidade Usuario não pode ser vazio")
    private String senha;

    @ManyToOne
    @JoinColumn(name = "equipe_id")
    private Equipe equipe;

    @ManyToOne
    @JoinColumn(name = "tarefa_id")
    private Tarefa tarefa;

    public void partialUpdate(Usuario u) {
        if(u.getNome() != null){
            this.setNome(u.getNome());
        }
        if(u.getSobrenome() != null){
            this.setSobrenome(u.getSobrenome());
        }
        if(u.getEmail() != null){
            this.setEmail(u.getEmail());
        }
        if(u.getTarefa() != null){
            this.setTarefa(u.getTarefa());
        }
        if(u.getSenha() != null){
            this.setSenha(u.getSenha());
        }
        if(u.getEquipe() != null){
            this.setEquipe(u.getEquipe());
        }
    }
}