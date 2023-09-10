package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.taskflow.core.base.BaseModel;

@Entity
@Table(name = "usuario")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class Usuario extends BaseModel {
    @Column
    @NotBlank(message = "O campo 'Nome' da entidade Usuario não pode ser vazio")
    private String nome;

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