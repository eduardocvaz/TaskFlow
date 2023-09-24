package ufrn.br.taskflow.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ufrn.br.taskflow.dto.*;
import ufrn.br.taskflow.mapper.ProjetoMapper;
import ufrn.br.taskflow.model.Projeto;
import ufrn.br.taskflow.service.ProjetoService;

import java.net.URI;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    private final ProjetoMapper mapper;

    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> create(@RequestBody ProjetoRequestDTO dto){
        Projeto projeto = mapper.toProjeto(dto);
        Projeto created = service.insert(projeto);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(created.getId())
                .toUri();

        //ProjetoResponseDTO responseDTO = mapper.toProjetoResponseDTO(created);
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody ProjetoRequestDTO dto){
        Projeto projeto = mapper.toProjeto(dto);
        projeto.setId(id);
        service.update(projeto);
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchUpdate(@PathVariable Long id, @RequestBody ProjetoRequestDTO dto){
        Projeto projeto = mapper.toProjeto(dto);
        projeto.setId(id);
        service.patchUpdate(projeto);
    }

    @GetMapping
    public Page<ProjetoResponseDTO> listAll(Pageable pageable){
        Page<Projeto> projetosPage = service.findAll(pageable);
        return projetosPage.map(mapper::toProjetoResponseDTO);
    }

    @GetMapping("{id}")
    public ProjetoResponseDTO getById(@PathVariable Long id){
        Projeto projeto = service.findById(id);
        ProjetoResponseDTO responseDTO = mapper.toProjetoResponseDTO(projeto);
        responseDTO.addLinks();
        return responseDTO;
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
