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
}