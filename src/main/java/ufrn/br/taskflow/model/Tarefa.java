package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tarefa_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @Column
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
            name = "tarefa_usuario_tbl",
            joinColumns = {@JoinColumn(name = "tarefa_id", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "usuario_id")})
    Set<Usuario> usuarios;

}
