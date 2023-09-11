package ufrn.br.taskflow.dto;

import lombok.Data;

@Data
public class TarefaRequestDTO {
    private String nome;
    private String descricao;
    private String status;
}
