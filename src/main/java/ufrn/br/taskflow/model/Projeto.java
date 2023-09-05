package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.taskflow.core.BaseModel;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "projeto")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class Projeto extends BaseModel {
    @Column
    private String nome;

    @Column
    private Date dataInicio;

    @Column
    private Date dataTerminoPrevista;

    @Column
    private String descricao;

    @ManyToMany
    @JoinTable(
            name = "projeto_equipe",
            joinColumns = {@JoinColumn(name = "projeto_id", referencedColumnName = "id") },
            inverseJoinColumns = {@JoinColumn(name = "equipe_id")})
    Set<Equipe> equipes;

    @OneToOne
    @JoinColumn(name = "gerente_id")
    private Usuario gerente;
}
