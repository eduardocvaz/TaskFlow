package ufrn.br.taskflow.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioResponseDTO {
    private String id;
    private String nome;
    private String email;
    private Long equipe;
    private Long tarefa;
}
