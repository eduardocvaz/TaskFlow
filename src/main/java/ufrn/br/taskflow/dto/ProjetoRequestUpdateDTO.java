package ufrn.br.taskflow.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ProjetoRequestUpdateDTO {
    private Long id;
    private String nome;
    private String descricao;
    private Date dataInicio;
    private Date dataTerminoPrevista;
}
