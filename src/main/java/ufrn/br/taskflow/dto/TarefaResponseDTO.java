package ufrn.br.taskflow.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TarefaResponseDTO {
    private Long id;
    private String nome;
    private String descricao;
    private String status;
    private Date dataInicio;
    private Date dataConclusaoPrevista;
    private Long projetoId;
}
