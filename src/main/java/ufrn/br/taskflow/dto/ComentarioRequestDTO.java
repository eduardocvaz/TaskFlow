package ufrn.br.taskflow.dto;

import lombok.Data;

@Data
public class ComentarioRequestDTO {
    private String texto;
    private Long tarefaId;
}
