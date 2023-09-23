package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.dto.ComentarioRequestDTO;
import ufrn.br.taskflow.dto.ComentarioRequestUpdateDTO;
import ufrn.br.taskflow.dto.ComentarioResponseDTO;
import ufrn.br.taskflow.dto.EquipeResponseDTO;
import ufrn.br.taskflow.mapper.ComentarioMapper;
import ufrn.br.taskflow.model.Comentario;
import ufrn.br.taskflow.model.Equipe;
import ufrn.br.taskflow.service.ComentarioService;

import java.net.URI;

@RestController
@RequestMapping("/comentarios")
@RequiredArgsConstructor
public class ComentarioController {
    private final ComentarioService service;

    private final ComentarioMapper mapper;

    @PostMapping
    public ResponseEntity<ComentarioResponseDTO> create(@RequestBody ComentarioRequestDTO dto){
        Comentario comentario = mapper.toComentario(dto);
        Comentario created = service.insert(comentario);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        //ComentarioResponseDTO responseDTO = mapper.toComentarioResponseDTO(created);
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody ComentarioRequestUpdateDTO dto){
        Comentario comentario = mapper.toComentario(dto);
        service.update(comentario);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchUpdate(@RequestBody ComentarioRequestUpdateDTO dto){
        Comentario comentario = mapper.toComentario(dto);
        service.patchUpdate(comentario);
    }

    @GetMapping
    public Page<ComentarioResponseDTO> listAll(Pageable pageable){
        Page<Comentario> comentariosPage = service.findAll(pageable);
        return comentariosPage.map(mapper::toComentarioResponseDTO);
    }

    @GetMapping("{id}")
    public ComentarioResponseDTO getById(@PathVariable Long id){
        Comentario comentario = service.findById(id);
        ComentarioResponseDTO responseDTO = mapper.toComentarioResponseDTO(comentario);
        responseDTO.addLinks();
        return responseDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
