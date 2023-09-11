package ufrn.br.taskflow.dto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ufrn.br.taskflow.model.Tarefa;

@Component
public class TarefaMapper {
    ModelMapper mapper;

    @Autowired
    public TarefaMapper(ModelMapper mapper){
        this.mapper = mapper;
    }

    /**
     * Converte um TarefaRequestDTO em Tarefa
     * @param dto
     * @return usuario
     */
    public Tarefa toTarefa(TarefaRequestDTO dto){
        Tarefa tarefa = mapper.map(dto, Tarefa.class);
        return tarefa;
    }

    /**
     * Converte um Tarefa em TarefaResponseDTO
     * @param created
     * @return responseDTO
     */
    public TarefaResponseDTO toTarefaResponseDTO(Tarefa created){
        TarefaResponseDTO responseDTO = mapper.map(created, TarefaResponseDTO.class);
        return responseDTO;
    }
}
