package ufrn.br.taskflow.dto;

import lombok.Data;

@Data
public class FuncaoRequestUpdateDTO {
    private Long id;
    private String nome;
    private String descricao;
}
