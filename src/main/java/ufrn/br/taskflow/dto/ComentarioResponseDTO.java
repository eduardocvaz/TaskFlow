package ufrn.br.taskflow.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ComentarioResponseDTO {
    private Long id;
    private String texto;
    private Date dataCriacao;
    private Long tarefaId;
}
