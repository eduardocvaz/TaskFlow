package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.dto.EquipeRequestDTO;
import ufrn.br.taskflow.dto.EquipeRequestUpdateDTO;
import ufrn.br.taskflow.dto.EquipeResponseDTO;
import ufrn.br.taskflow.dto.FuncaoResponseDTO;
import ufrn.br.taskflow.mapper.EquipeMapper;
import ufrn.br.taskflow.model.Equipe;
import ufrn.br.taskflow.model.Funcao;
import ufrn.br.taskflow.service.EquipeService;

import java.net.URI;

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

        //EquipeResponseDTO responseDTO = mapper.toEquipeResponseDTO(created);
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody EquipeRequestUpdateDTO dto){
        Equipe equipe = mapper.toEquipe(dto);
        service.update(equipe);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchUpdate(@RequestBody EquipeRequestUpdateDTO dto){
        Equipe equipe = mapper.toEquipe(dto);
        service.patchUpdate(equipe);
    }

    @GetMapping
    public Page<EquipeResponseDTO> listAll(Pageable pageable){
        Page<Equipe> equipesPage = service.findAll(pageable);
        return equipesPage.map(mapper::toEquipeResponseDTO);
    }

    @GetMapping("{id}")
    public EquipeResponseDTO getById(@PathVariable Long id){
        Equipe equipe = service.findById(id);
        EquipeResponseDTO responseDTO = mapper.toEquipeResponseDTO(equipe);
        responseDTO.addLinks();
        return responseDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
