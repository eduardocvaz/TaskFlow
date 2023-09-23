package ufrn.br.taskflow.dto;

import lombok.Data;

@Data
public class TarefaRequestUpdateDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String status;
}
