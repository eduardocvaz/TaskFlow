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
import ufrn.br.taskflow.model.Usuario;
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

        //TarefaResponseDTO responseDTO = mapper.toTarefaResponseDTO(created);
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody TarefaRequestUpdateDTO dto){
        Tarefa tarefa = mapper.toTarefa(dto);
        service.update(tarefa);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchUpdate(@RequestBody TarefaRequestUpdateDTO dto){
        Tarefa tarefa = mapper.toTarefa(dto);
        service.patchUpdate(tarefa);
    }

    @GetMapping
    public Page<TarefaResponseDTO> listAll(Pageable pageable){
        Page<Tarefa> tarefasPage = service.findAll(pageable);
        return tarefasPage.map(mapper::toTarefaResponseDTO);
    }

    @GetMapping("{id}")
    public TarefaResponseDTO getById(@PathVariable Long id){
        Tarefa tarefa = service.findById(id);
        TarefaResponseDTO responseDTO = mapper.toTarefaResponseDTO(tarefa);
        responseDTO.addLinks();
        return responseDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
