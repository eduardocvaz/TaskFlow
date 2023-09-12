package ufrn.br.taskflow.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ufrn.br.taskflow.model.Funcao;

@Component
public class FuncaoMapper {
    ModelMapper mapper;

    @Autowired
    public FuncaoMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    /**
     * Converte um FuncaoRequestDTO em Funcao
     * @param dto
     * @return funcao
     */
    public Funcao toProjeto(FuncaoRequestDTO dto){
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
