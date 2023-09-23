package ufrn.br.taskflow.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ufrn.br.taskflow.dto.UsuarioRequestDTO;
import ufrn.br.taskflow.dto.UsuarioRequestUpdateDTO;
import ufrn.br.taskflow.dto.UsuarioResponseDTO;
import ufrn.br.taskflow.model.Usuario;

@Component
@AllArgsConstructor
public class UsuarioMapper {
    private final ModelMapper mapper;

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
     * Converte um UsuarioRequesUpdatetDTO em Usuario
     * @param dto
     * @return usuario
     */
    public Usuario toUsuario(UsuarioRequestUpdateDTO dto){
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
