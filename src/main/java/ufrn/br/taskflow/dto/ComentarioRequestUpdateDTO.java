package ufrn.br.taskflow.dto;

import lombok.Data;

@Data
public class ComentarioRequestUpdateDTO {
    private Long id;
    private String texto;
    private Long tarefaId;
}
