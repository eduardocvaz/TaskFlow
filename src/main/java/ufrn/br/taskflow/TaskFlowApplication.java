package ufrn.br.taskflow;

import jakarta.annotation.PostConstruct;
import org.aspectj.apache.bcel.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ufrn.br.taskflow.model.Funcao;
import ufrn.br.taskflow.model.Usuario;
import ufrn.br.taskflow.repository.FuncaoRepository;
import ufrn.br.taskflow.repository.UsuarioRepository;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class TaskFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskFlowApplication.class, args);
    }

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    FuncaoRepository funcaoRepository;


    @PostConstruct
    public void started() {
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setSenha("12345");
        usuarioRepository.save(usuario);


        Funcao funcao1 = new Funcao();
        funcao1.setNome("DEV-FRONT");
        funcao1.setDescricao("Desenvolvedor Front-End");

        Funcao funcao2 = new Funcao();
        funcao2.setNome("DEV-BACK");
        funcao2.setDescricao("Desenvolvedor Back-End");

        funcao1.setUsuario(usuario);
        funcao2.setUsuario(usuario);

        funcaoRepository.save(funcao1);
        funcaoRepository.save(funcao2);
    }
}
