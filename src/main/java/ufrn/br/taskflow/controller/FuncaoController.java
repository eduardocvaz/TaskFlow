package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.dto.*;
import ufrn.br.taskflow.model.Funcao;
import ufrn.br.taskflow.model.Projeto;
import ufrn.br.taskflow.service.FuncaoService;
import ufrn.br.taskflow.service.ProjetoService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcoes")
@RequiredArgsConstructor
public class FuncaoController {
    private FuncaoService service;

    private FuncaoMapper mapper;

    @Autowired
    public FuncaoController(FuncaoService service, FuncaoMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<FuncaoResponseDTO> create(@RequestBody FuncaoRequestDTO dto){
        Funcao funcao = mapper.toProjeto(dto);
        Funcao created = service.insert(funcao);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        FuncaoResponseDTO responseDTO = mapper.toFuncaoResponseDTO(created);
        return ResponseEntity.created(location).body(responseDTO);
    }

    @PutMapping
    public Funcao update(@RequestBody Funcao f){
        return service.update(f);
    }

    @PatchMapping
    public Funcao patchUpdate(@RequestBody Funcao f){
        return service.patchUpdate(f);
    }

    @GetMapping
    public List<FuncaoResponseDTO> listaAll(){
        List<FuncaoResponseDTO> funcoes = new ArrayList<>();

        for (Funcao funcao : service.findAll()) {
            funcoes.add(mapper.toFuncaoResponseDTO(funcao));
        }

        return funcoes;
    }

    @GetMapping("{id}")
    public Funcao getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

}
