package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.dto.*;
import ufrn.br.taskflow.model.Projeto;
import ufrn.br.taskflow.service.ProjetoService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private ProjetoService service;

    private ProjetoMapper mapper;

    @Autowired
    public ProjetoController(ProjetoService service, ProjetoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> create(@RequestBody ProjetoRequestDTO dto){
        Projeto projeto = mapper.toProjeto(dto);
        Projeto created = service.insert(projeto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        ProjetoResponseDTO responseDTO = mapper.toProjetoResponseDTO(created);
        return ResponseEntity.created(location).body(responseDTO);
    }

    @PutMapping
    public Projeto update(@RequestBody Projeto p){
        return service.update(p);
    }

    @PatchMapping
    public Projeto patchUpdate(@RequestBody Projeto p){
        return service.patchUpdate(p);
    }

    @GetMapping
    public List<ProjetoResponseDTO> listaAll(){
        List<ProjetoResponseDTO> projetos = new ArrayList<>();

        for (Projeto projeto : service.findAll()) {
            projetos.add(mapper.toProjetoResponseDTO(projeto));
        }

        return projetos;
    }

    @GetMapping("{id}")
    public Projeto getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
