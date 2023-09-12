package ufrn.br.taskflow.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ufrn.br.taskflow.model.Projeto;

@Component
public class ProjetoMapper {
    ModelMapper mapper;

    @Autowired
    public ProjetoMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

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
