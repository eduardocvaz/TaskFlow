package ufrn.br.taskflow;

import jakarta.annotation.PostConstruct;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import ufrn.br.taskflow.core.config.RsaKeyProperties;
import ufrn.br.taskflow.model.Funcao;
import ufrn.br.taskflow.model.Tarefa;
import ufrn.br.taskflow.model.Usuario;
import ufrn.br.taskflow.repository.FuncaoRepository;
import ufrn.br.taskflow.repository.ProjetoRepository;
import ufrn.br.taskflow.repository.TarefaRepository;
import ufrn.br.taskflow.repository.UsuarioRepository;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class TaskFlowApplication {

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(TaskFlowApplication.class, args);
    }

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    FuncaoRepository funcaoRepository;

    @Autowired
    TarefaRepository tarefaRepository;

    @Autowired
    ProjetoRepository projetoRepository;


    @PostConstruct
    public void started() {
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setSobrenome("Silva");
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

        Tarefa tarefa1 = new Tarefa();
        tarefa1.setNome("Fazer front-end do projeto");
        tarefa1.setDescricao("Implementar o front-end utilizando Angular");
        tarefaRepository.save(tarefa1);
    }
}
