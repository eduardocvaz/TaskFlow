package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.dto.EquipeRequestDTO;
import ufrn.br.taskflow.dto.EquipeResponseDTO;
import ufrn.br.taskflow.mapper.EquipeMapper;
import ufrn.br.taskflow.model.Equipe;
import ufrn.br.taskflow.model.Funcao;
import ufrn.br.taskflow.service.EquipeService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/equipes")
@RequiredArgsConstructor
public class EquipeController {
    private final EquipeService service;

    private final EquipeMapper mapper;

    @PostMapping
    public ResponseEntity<EquipeResponseDTO> create(@RequestBody EquipeRequestDTO dto){
        Equipe equipe = mapper.toEquipe(dto);
        Equipe created = service.insert(equipe);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        EquipeResponseDTO responseDTO = mapper.toEquipeResponseDTO(created);
        return ResponseEntity.created(location).body(responseDTO);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Equipe e){
        service.update(e);
    }

    @PatchMapping
    public Equipe patchUpdate(@RequestBody Equipe e){
        return service.patchUpdate(e);
    }

    @GetMapping
    public List<EquipeResponseDTO> listaAll(Pageable pageable){
        List<EquipeResponseDTO> equipes = new ArrayList<>();

        for (Equipe equipe : service.findAll()) {
            equipes.add(mapper.toEquipeResponseDTO(equipe));
        }

        return equipes;
    }

    @GetMapping("{id}")
    public Equipe getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
