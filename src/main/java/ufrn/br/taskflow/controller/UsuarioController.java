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

        //UsuarioResponseDTO responseDTO = mapper.toUsuarioResponseDTO(created);
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody UsuarioRequestDTO dto){
        Usuario usuario = mapper.toUsuario(dto);
        usuario.setId(id);
        service.update(usuario);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchUpdate(@PathVariable Long id, @RequestBody UsuarioRequestDTO dto){
        Usuario usuario = mapper.toUsuario(dto);
        usuario.setId(id);
        service.patchUpdate(usuario);
    }

    @GetMapping
    public Page<UsuarioResponseDTO> listaAll(Pageable pageable){
        Page<Usuario> usuariosPage = service.findAll(pageable);
        return usuariosPage.map(mapper::toUsuarioResponseDTO);
    }

    @GetMapping("{id}")
    public UsuarioResponseDTO getById(@PathVariable Long id){
        Usuario usuario = service.findById(id);
        UsuarioResponseDTO responseDTO = mapper.toUsuarioResponseDTO(usuario);

        responseDTO.addLinks();
        return responseDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
