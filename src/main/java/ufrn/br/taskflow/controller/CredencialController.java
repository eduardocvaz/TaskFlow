package ufrn.br.taskflow.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ufrn.br.taskflow.dto.CredencialDTO;
import ufrn.br.taskflow.model.Credencial;
import ufrn.br.taskflow.model.Usuario;
import ufrn.br.taskflow.service.CredencialService;

@RestController
@RequestMapping("/credenciais")
public class CredencialController {

    CredencialService service;

    public CredencialController(CredencialService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CredencialDTO credencialDTO){
        Usuario u = new Usuario();
        u.setNome(credencialDTO.getNome());
        u.setSobrenome(credencialDTO.getSobrenome());
        u.setSenha(credencialDTO.getPassword());

        Credencial c = new Credencial();
        c.setUsuario(u);
        c.setUsername(credencialDTO.getUsername());
        c.setPassword(credencialDTO.getPassword());
        c.setRoles(credencialDTO.getRoles());

        service.create(c);

        return ResponseEntity.noContent().build();
    }
}