package ufrn.br.taskflow.dto;

import lombok.Data;

@Data
public class CredencialDTO {
    private String username;
    private String password;
    private String roles;
    private String nome;
    private String sobrenome;
}
