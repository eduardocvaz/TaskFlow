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
@Table(name = "projeto")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class Projeto extends BaseModel {
    @Column
    @NotBlank(message = "O campo 'Nome' da entidade Projeto não pode ser vazio")
    private String nome;

    @Column
    private Date dataInicio;

    @Column
    private Date dataTerminoPrevista;

    @Column
    @Size(max = 200, message = "O campo 'descricao' da entidade Projeto deve ter no máximo 200 caracteres")
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

    public void partialUpdate(Projeto p) {
        if(p.getNome() != null){
            this.setNome(p.getNome());
        }
        if(p.getDescricao() != null){
            this.setDescricao(p.getDescricao());
        }
        if(p.getDataInicio() != null){
            this.setDataInicio(p.getDataInicio());
        }
        if(p.getDataTerminoPrevista() != null){
            this.setDataTerminoPrevista(p.getDataTerminoPrevista());
        }
        if(p.getGerente() != null){
            this.setGerente(p.getGerente());
        }
        if(p.getEquipes() != null){
            this.setEquipes(p.getEquipes());
        }
    }
}
