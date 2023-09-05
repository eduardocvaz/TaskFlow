package ufrn.br.taskflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ufrn.br.taskflow.core.base.BaseModel;

@Entity
@Table(name = "equipe")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor

public class Equipe extends BaseModel {
    @Column
    private String nome;

    @Column
    private String descricao;
}