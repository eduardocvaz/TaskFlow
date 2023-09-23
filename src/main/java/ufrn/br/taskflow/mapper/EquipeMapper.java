package ufrn.br.taskflow.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ufrn.br.taskflow.dto.EquipeRequestDTO;
import ufrn.br.taskflow.dto.EquipeRequestUpdateDTO;
import ufrn.br.taskflow.dto.EquipeResponseDTO;
import ufrn.br.taskflow.model.Equipe;

@Component
@AllArgsConstructor
public class EquipeMapper {
    private final ModelMapper mapper;

    /**
     * Converte um EquipeRequestDTO em Equipe
     * @param dto
     * @return equipe
     */
    public Equipe toEquipe(EquipeRequestDTO dto){
        Equipe equipe = mapper.map(dto, Equipe.class);
        return equipe;
    }

    /**
     * Converte um EquipeRequestUpdateDTO em Equipe
     * @param dto
     * @return equipe
     */
    public Equipe toEquipe(EquipeRequestUpdateDTO dto){
        Equipe equipe = mapper.map(dto, Equipe.class);
        return equipe;
    }

    /**
     * Converte um Equipe em EquipeResponseDTO
     * @param created
     * @return responseDTO
     */
    public EquipeResponseDTO toEquipeResponseDTO(Equipe created){
        EquipeResponseDTO responseDTO = mapper.map(created, EquipeResponseDTO.class);
        return responseDTO;
    }
}
