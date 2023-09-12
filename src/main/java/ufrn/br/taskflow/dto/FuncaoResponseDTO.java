package ufrn.br.taskflow.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FuncaoResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
}
