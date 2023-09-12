package ufrn.br.taskflow.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class ProjetoRequestDTO {
    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataTerminoPrevista;
}
