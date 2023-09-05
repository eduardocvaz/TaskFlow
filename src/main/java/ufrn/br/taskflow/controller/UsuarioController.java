package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.model.Usuario;
import ufrn.br.taskflow.service.UsuarioService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario u){
        Usuario created = service.insert(u);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        return ResponseEntity.created(location).body(created);
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
    public List<Usuario> listaAll(){
        return service.findAll();
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
