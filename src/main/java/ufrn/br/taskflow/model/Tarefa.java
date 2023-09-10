package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.taskflow.core.base.BaseModel;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tarefa")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class Tarefa extends BaseModel {
    @Column
    @NotBlank(message = "O campo 'Nome' da entidade Tarefa não pode ser vazio")
    private String nome;

    @Column
    @Size(max = 200, message = "O campo 'descricao' da entidade Tarefa deve ter no máximo 200 caracteres")
    private String descricao;

    @Column
    private String status; //trocar por um ENUM

    @Column
    private Date dataInicio;

    @Column
    private Date dataConclusaoPrevista;

    @ManyToOne
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;

    @ManyToMany
    @JoinTable(
            name = "tarefa_usuario",
            joinColumns = {@JoinColumn(name = "tarefa_id", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "usuario_id")})
    Set<Usuario> usuarios;

}
