package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.dto.*;
import ufrn.br.taskflow.mapper.FuncaoMapper;
import ufrn.br.taskflow.model.Funcao;
import ufrn.br.taskflow.service.FuncaoService;

import java.net.URI;

@RestController
@RequestMapping("/funcoes")
@RequiredArgsConstructor
public class FuncaoController {

    private final FuncaoService service;

    private final FuncaoMapper mapper;

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
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Funcao f){
        service.update(f);
    }

    @PatchMapping
    public Funcao patchUpdate(@RequestBody Funcao f){
        return service.patchUpdate(f);
    }

    @GetMapping
    public Page<FuncaoResponseDTO> listAll(Pageable pageable){
        Page<Funcao> funcoesPage = service.findAll(pageable);
        return funcoesPage.map(mapper::toFuncaoResponseDTO);
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
