package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.dto.*;
import ufrn.br.taskflow.mapper.TarefaMapper;
import ufrn.br.taskflow.model.Tarefa;
import ufrn.br.taskflow.service.TarefaService;

import java.net.URI;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    private final TarefaService service;
    private final TarefaMapper mapper;

    @PostMapping
    public ResponseEntity<TarefaResponseDTO> create(@RequestBody TarefaRequestDTO dto){
        Tarefa tarefa = mapper.toTarefa(dto);
        Tarefa created = service.insert(tarefa);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        TarefaResponseDTO responseDTO = mapper.toTarefaResponseDTO(created);
        return ResponseEntity.created(location).body(responseDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Tarefa t){
        service.update(t);
    }

    @PatchMapping
    public Tarefa patchUpdate(@RequestBody Tarefa t){
        return service.patchUpdate(t);
    }

    @GetMapping
    public Page<TarefaResponseDTO> listAll(Pageable pageable){
        Page<Tarefa> tarefasPage = service.findAll(pageable);
        return tarefasPage.map(mapper::toTarefaResponseDTO);
    }

    @GetMapping("{id}")
    public TarefaResponseDTO getById(@PathVariable Long id){
        Tarefa tarefaBuscada = service.findById(id);
        return mapper.toTarefaResponseDTO(tarefaBuscada);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
