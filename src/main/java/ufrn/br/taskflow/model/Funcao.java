package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "funcao_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcao {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;


}
