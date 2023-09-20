package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.taskflow.core.base.BaseModel;

import java.util.Set;

@Entity
@Table(name = "equipe")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Equipe extends BaseModel {
    @Column
    @NotBlank(message = "O campo 'Nome' da entidade Equipe não pode ser vazio")
    private String nome;

    @Column
    @Size(max = 100, message = "O campo 'descricao' da entidade Funcao deve ter no máximo 100 caracteres")
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "equipe_usuario",
            joinColumns = {@JoinColumn(name = "equipe_id", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "usuario_id")})
    Set<Usuario> membros;

    public void partialUpdate(Equipe e) {
        if(e.getNome() != null){
            this.setNome(e.getNome());
        }
        if(e.getDescricao() != null){
            this.setDescricao(e.getDescricao());
        }
        if(e.getMembros() != null){
            this.setMembros(e.getMembros());
        }
    }

}