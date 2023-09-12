package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.dto.*;
import ufrn.br.taskflow.model.Tarefa;
import ufrn.br.taskflow.service.TarefaService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {
    private TarefaService service;
    private TarefaMapper mapper;

    @Autowired
    public TarefaController(TarefaService service, TarefaMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

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
    public Tarefa update(@RequestBody Tarefa t){
        return service.update(t);
    }

    @PatchMapping
    public Tarefa patchUpdate(@RequestBody Tarefa t){
        return service.patchUpdate(t);
    }

    @GetMapping
    public List<TarefaResponseDTO> listaAll(){
        List<TarefaResponseDTO> tarefas = new ArrayList<>();
        for (Tarefa tarefa : service.findAll()) {
            tarefas.add(mapper.toTarefaResponseDTO(tarefa));
        }

        return tarefas;
    }

    @GetMapping("{id}")
    public Tarefa getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
