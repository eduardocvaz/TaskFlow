package ufrn.br.taskflow.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ufrn.br.taskflow.dto.FuncaoRequestDTO;
import ufrn.br.taskflow.dto.FuncaoResponseDTO;
import ufrn.br.taskflow.model.Funcao;

@Component
@AllArgsConstructor
public class FuncaoMapper {
    private final ModelMapper mapper;

    /**
     * Converte um FuncaoRequestDTO em Funcao
     * @param dto
     * @return funcao
     */
    public Funcao toFuncao(FuncaoRequestDTO dto){
        Funcao funcao = mapper.map(dto, Funcao.class);
        return funcao;
    }

    /**
     * Converte um Funcao em FuncaoResponseDTO
     * @param created
     * @return responseDTO
     */
    public FuncaoResponseDTO toFuncaoResponseDTO(Funcao created){
        FuncaoResponseDTO responseDTO = mapper.map(created, FuncaoResponseDTO.class);
        return responseDTO;
    }
}
