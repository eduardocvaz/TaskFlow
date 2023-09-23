package ufrn.br.taskflow.dto;

import lombok.Data;

@Data
public class EquipeRequestUpdateDTO {
    private Long id;
    private String nome;
    private String descricao;
}
