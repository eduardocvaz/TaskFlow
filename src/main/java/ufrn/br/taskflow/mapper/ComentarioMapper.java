package ufrn.br.taskflow.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ufrn.br.taskflow.dto.ComentarioRequestDTO;
import ufrn.br.taskflow.dto.ComentarioResponseDTO;
import ufrn.br.taskflow.model.Comentario;

@Component
@AllArgsConstructor
public class ComentarioMapper {
    private final ModelMapper mapper;

    /**
     * Converte um ComentarioRequestDTO em Comentario
     * @param dto
     * @return comentario
     */
    public Comentario toComentario(ComentarioRequestDTO dto){
        Comentario comentario = mapper.map(dto, Comentario.class);
        return comentario;
    }

    /**
     * Converte um Comentario em ComentarioResponseDTO
     * @param created
     * @return responseDTO
     */
    public ComentarioResponseDTO toComentarioResponseDTO(Comentario created){
        ComentarioResponseDTO responseDTO = mapper.map(created, ComentarioResponseDTO.class);
        return responseDTO;
    }
}
