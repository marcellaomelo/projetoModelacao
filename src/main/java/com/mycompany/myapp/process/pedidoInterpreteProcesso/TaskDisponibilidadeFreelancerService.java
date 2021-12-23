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
public class TaskDisponibilidadeFreelancerService {

    private final TaskInstanceService taskInstanceService;

    private final PedidoInterpreteService pedidoInterpreteService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskDisponibilidadeFreelancerMapper taskDisponibilidadeFreelancerMapper;

    private final PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper;

    public TaskDisponibilidadeFreelancerService(
        TaskInstanceService taskInstanceService,
        PedidoInterpreteService pedidoInterpreteService,
        TaskInstanceRepository taskInstanceRepository,
        PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskDisponibilidadeFreelancerMapper taskDisponibilidadeFreelancerMapper,
        PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.pedidoInterpreteService = pedidoInterpreteService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.pedidoInterpreteProcessoRepository = pedidoInterpreteProcessoRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskDisponibilidadeFreelancerMapper = taskDisponibilidadeFreelancerMapper;
        this.pedidoInterpreteProcessoMapper = pedidoInterpreteProcessoMapper;
    }

    public TaskDisponibilidadeFreelancerContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskDisponibilidadeFreelancerMapper::toPedidoInterpreteProcessoDTO)
            .orElseThrow();

        TaskDisponibilidadeFreelancerContextDTO taskDisponibilidadeFreelancerContext = new TaskDisponibilidadeFreelancerContextDTO();
        taskDisponibilidadeFreelancerContext.setTaskInstance(taskInstanceDTO);
        taskDisponibilidadeFreelancerContext.setPedidoInterpreteProcesso(pedidoInterpreteProcesso);

        return taskDisponibilidadeFreelancerContext;
    }

    public TaskDisponibilidadeFreelancerContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskDisponibilidadeFreelancerContextDTO taskDisponibilidadeFreelancerContext) {
        PedidoInterpreteDTO pedidoInterpreteDTO = pedidoInterpreteService
            .findOne(taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getId())
            .orElseThrow();
        pedidoInterpreteDTO.setDataPedido(
            taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getDataPedido()
        );
        pedidoInterpreteDTO.setLocalTuristicoPedido(
            taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getLocalTuristicoPedido()
        );
        pedidoInterpreteDTO.setClienteName(
            taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteName()
        );
        pedidoInterpreteDTO.setClienteEmail(
            taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteEmail()
        );
        pedidoInterpreteDTO.setFreelancerNumeroReserva(
            taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancerNumeroReserva()
        );
        pedidoInterpreteDTO.setFreelancer(
            taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer()
        );
        pedidoInterpreteDTO.setFreelancer(
            taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer()
        );
        pedidoInterpreteDTO.setFreelancer(
            taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer()
        );
        pedidoInterpreteDTO.setFreelancer(
            taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer()
        );
        pedidoInterpreteService.save(pedidoInterpreteDTO);
    }

    public void complete(TaskDisponibilidadeFreelancerContextDTO taskDisponibilidadeFreelancerContext) {
        save(taskDisponibilidadeFreelancerContext);
        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskDisponibilidadeFreelancerContext.getPedidoInterpreteProcesso().getProcessInstance().getId())
            .map(pedidoInterpreteProcessoMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskDisponibilidadeFreelancerContext.getTaskInstance(), pedidoInterpreteProcesso);
    }
}
