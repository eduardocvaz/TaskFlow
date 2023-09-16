package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.mapper.UsuarioMapper;
import ufrn.br.taskflow.dto.UsuarioRequestDTO;
import ufrn.br.taskflow.dto.UsuarioResponseDTO;
import ufrn.br.taskflow.model.Usuario;
import ufrn.br.taskflow.service.UsuarioService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    private final UsuarioMapper mapper;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> create(@RequestBody UsuarioRequestDTO dto){
        Usuario usuario = mapper.toUsuario(dto);
        Usuario created = service.insert(usuario);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        UsuarioResponseDTO responseDTO = mapper.toUsuarioResponseDTO(created);
        return ResponseEntity.created(location).body(responseDTO);
    }

    @PutMapping
    public Usuario update(@RequestBody Usuario u){
        return service.update(u);
    }

    @PatchMapping
    public Usuario patchUpdate(@RequestBody Usuario u){
        return service.patchUpdate(u);
    }

    @GetMapping
    public Page<Usuario> listaAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping("{id}")
    public Usuario getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
