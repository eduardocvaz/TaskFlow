package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Table(name = "equipe_tbl")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;


}