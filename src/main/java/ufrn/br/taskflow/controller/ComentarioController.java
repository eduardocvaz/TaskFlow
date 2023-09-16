package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.dto.ComentarioRequestDTO;
import ufrn.br.taskflow.dto.ComentarioResponseDTO;
import ufrn.br.taskflow.mapper.ComentarioMapper;
import ufrn.br.taskflow.model.Comentario;
import ufrn.br.taskflow.service.ComentarioService;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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

        ComentarioResponseDTO responseDTO = mapper.toComentarioResponseDTO(created);
        return ResponseEntity.created(location).body(responseDTO);
    }

    @PutMapping
    public Comentario update(@RequestBody Comentario c){
        return service.update(c);
    }

    @PatchMapping
    public Comentario patchUpdate(@RequestBody Comentario c){
        return service.patchUpdate(c);
    }

    @GetMapping
    public List<ComentarioResponseDTO> listaAll(Pageable pageable){
        List<ComentarioResponseDTO> comentarios = new ArrayList<>();

        for (Comentario comentario : service.findAll()) {
            comentarios.add(mapper.toComentarioResponseDTO(comentario));
        }

        return comentarios;
    }

    @GetMapping("{id}")
    public Comentario getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
