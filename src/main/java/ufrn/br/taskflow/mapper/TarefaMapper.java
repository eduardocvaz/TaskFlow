package ufrn.br.taskflow.mapper;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ufrn.br.taskflow.dto.TarefaRequestDTO;
import ufrn.br.taskflow.dto.TarefaResponseDTO;
import ufrn.br.taskflow.model.Tarefa;

@Component
@AllArgsConstructor
public class TarefaMapper {
    private final ModelMapper mapper;

    /**
     * Converte um TarefaRequestDTO em Tarefa
     * @param dto
     * @return tarefa
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
