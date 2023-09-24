package ufrn.br.taskflow.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ufrn.br.taskflow.dto.ProjetoRequestDTO;
import ufrn.br.taskflow.dto.ProjetoResponseDTO;
import ufrn.br.taskflow.model.Projeto;

@Component
@AllArgsConstructor
public class ProjetoMapper {
    private final ModelMapper mapper;

    /**
     * Converte um ProjetoRequestDTO em Projeto
     * @param dto
     * @return projeto
     */
    public Projeto toProjeto(ProjetoRequestDTO dto){
        Projeto projeto = mapper.map(dto, Projeto.class);
        return projeto;
    }


    /**
     * Converte um Projeto em ProjetoResponseDTO
     * @param created
     * @return responseDTO
     */
    public ProjetoResponseDTO toProjetoResponseDTO(Projeto created){
        ProjetoResponseDTO responseDTO = mapper.map(created, ProjetoResponseDTO.class);
        return responseDTO;
    }
}
