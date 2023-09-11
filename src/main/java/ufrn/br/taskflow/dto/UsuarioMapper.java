package ufrn.br.taskflow.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ufrn.br.taskflow.model.Usuario;

@Component
public class UsuarioMapper {
    ModelMapper mapper;

    @Autowired
    public UsuarioMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    /**
     * Converte um UsuarioRequestDTO em Usuario
     * @param dto
     * @return usuario
     */
    public Usuario toUsuario(UsuarioRequestDTO dto){
        Usuario usuario = mapper.map(dto, Usuario.class);
        return usuario;
    }

    /**
     * Converte um Usuario em UsuarioResponseDTO
     * @param created
     * @return responseDTO
     */
    public UsuarioResponseDTO toUsuarioResponseDTO(Usuario created){
        UsuarioResponseDTO responseDTO = mapper.map(created, UsuarioResponseDTO.class);
        //responseDTO.setNomeDaRua("Nome da rua - logica de negocio");
        return responseDTO;
    }

}
