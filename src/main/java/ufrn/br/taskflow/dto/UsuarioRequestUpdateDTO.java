package ufrn.br.taskflow.dto;

import lombok.Data;

@Data
public class UsuarioRequestUpdateDTO {
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String senha;
}