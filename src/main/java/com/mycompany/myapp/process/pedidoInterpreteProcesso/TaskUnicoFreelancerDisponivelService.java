package com.mycompany.myapp.process.pedidoInterpreteProcesso;

import com.mycompany.myapp.repository.PedidoInterpreteProcessoRepository;
import com.mycompany.myapp.service.PedidoInterpreteService;
import com.mycompany.myapp.service.dto.PedidoInterpreteDTO;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessoDTO;
import com.mycompany.myapp.service.mapper.PedidoInterpreteProcessoMapper;
import org.akip.repository.TaskInstanceRepository;
import org.akip.service.TaskInstanceService;
import org.akip.service.dto.TaskInstanceDTO;
import org.akip.service.mapper.TaskInstanceMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskUnicoFreelancerDisponivelService {

    private final TaskInstanceService taskInstanceService;

    private final PedidoInterpreteService pedidoInterpreteService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskUnicoFreelancerDisponivelMapper taskUnicoFreelancerDisponivelMapper;

    private final PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper;

    public TaskUnicoFreelancerDisponivelService(
        TaskInstanceService taskInstanceService,
        PedidoInterpreteService pedidoInterpreteService,
        TaskInstanceRepository taskInstanceRepository,
        PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskUnicoFreelancerDisponivelMapper taskUnicoFreelancerDisponivelMapper,
        PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.pedidoInterpreteService = pedidoInterpreteService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.pedidoInterpreteProcessoRepository = pedidoInterpreteProcessoRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskUnicoFreelancerDisponivelMapper = taskUnicoFreelancerDisponivelMapper;
        this.pedidoInterpreteProcessoMapper = pedidoInterpreteProcessoMapper;
    }

    public TaskUnicoFreelancerDisponivelContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskUnicoFreelancerDisponivelMapper::toPedidoInterpreteProcessoDTO)
            .orElseThrow();

        TaskUnicoFreelancerDisponivelContextDTO taskUnicoFreelancerDisponivelContext = new TaskUnicoFreelancerDisponivelContextDTO();
        taskUnicoFreelancerDisponivelContext.setTaskInstance(taskInstanceDTO);
        taskUnicoFreelancerDisponivelContext.setPedidoInterpreteProcesso(pedidoInterpreteProcesso);

        return taskUnicoFreelancerDisponivelContext;
    }

    public TaskUnicoFreelancerDisponivelContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskUnicoFreelancerDisponivelContextDTO taskUnicoFreelancerDisponivelContext) {
        PedidoInterpreteDTO pedidoInterpreteDTO = pedidoInterpreteService
            .findOne(taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getId())
            .orElseThrow();
        pedidoInterpreteDTO.setDataPedido(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getDataPedido()
        );
        pedidoInterpreteDTO.setLocalTuristicoPedido(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getLocalTuristicoPedido()
        );
        pedidoInterpreteDTO.setClienteName(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteName()
        );
        pedidoInterpreteDTO.setClienteEmail(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteEmail()
        );
        pedidoInterpreteDTO.setFreelancerNumeroReserva(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancerNumeroReserva()
        );
        pedidoInterpreteDTO.setFreelancer(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer()
        );
        pedidoInterpreteDTO.setFreelancer(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer()
        );
        pedidoInterpreteDTO.setFreelancer(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer()
        );
        pedidoInterpreteDTO.setFreelancer(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer()
        );
        pedidoInterpreteDTO.setFreelancer(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer()
        );
        pedidoInterpreteDTO.setFreelancer(
            taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer()
        );
        pedidoInterpreteService.save(pedidoInterpreteDTO);
    }

    public void complete(TaskUnicoFreelancerDisponivelContextDTO taskUnicoFreelancerDisponivelContext) {
        save(taskUnicoFreelancerDisponivelContext);
        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskUnicoFreelancerDisponivelContext.getPedidoInterpreteProcesso().getProcessInstance().getId())
            .map(pedidoInterpreteProcessoMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskUnicoFreelancerDisponivelContext.getTaskInstance(), pedidoInterpreteProcesso);
    }
}
