package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.taskflow.core.base.BaseModel;

@Entity
@Table(name = "funcao")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Funcao extends BaseModel {
    @Column
    @NotBlank(message = "O campo 'Nome' da entidade Funcao não pode ser vazio")
    private String nome;

    @Column
    @Size(max = 100, message = "O campo 'descricao' da entidade Funcao deve ter no máximo 100 caracteres")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public void partialUpdate(Funcao f) {
        if(f.getNome() != null){
            this.setNome(f.getNome());
        }
        if(f.getDescricao() != null){
            this.setDescricao(f.getDescricao());
        }
        if(f.getUsuario() != null){
            this.setUsuario(f.getUsuario());
        }

    }

}
