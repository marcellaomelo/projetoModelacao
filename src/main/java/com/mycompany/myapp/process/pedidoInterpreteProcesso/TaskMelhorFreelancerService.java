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
public class TaskMelhorFreelancerService {

    private final TaskInstanceService taskInstanceService;

    private final PedidoInterpreteService pedidoInterpreteService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskMelhorFreelancerMapper taskMelhorFreelancerMapper;

    private final PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper;

    public TaskMelhorFreelancerService(
        TaskInstanceService taskInstanceService,
        PedidoInterpreteService pedidoInterpreteService,
        TaskInstanceRepository taskInstanceRepository,
        PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskMelhorFreelancerMapper taskMelhorFreelancerMapper,
        PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.pedidoInterpreteService = pedidoInterpreteService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.pedidoInterpreteProcessoRepository = pedidoInterpreteProcessoRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskMelhorFreelancerMapper = taskMelhorFreelancerMapper;
        this.pedidoInterpreteProcessoMapper = pedidoInterpreteProcessoMapper;
    }

    public TaskMelhorFreelancerContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskMelhorFreelancerMapper::toPedidoInterpreteProcessoDTO)
            .orElseThrow();

        TaskMelhorFreelancerContextDTO taskMelhorFreelancerContext = new TaskMelhorFreelancerContextDTO();
        taskMelhorFreelancerContext.setTaskInstance(taskInstanceDTO);
        taskMelhorFreelancerContext.setPedidoInterpreteProcesso(pedidoInterpreteProcesso);

        return taskMelhorFreelancerContext;
    }

    public TaskMelhorFreelancerContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskMelhorFreelancerContextDTO taskMelhorFreelancerContext) {
        PedidoInterpreteDTO pedidoInterpreteDTO = pedidoInterpreteService
            .findOne(taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getId())
            .orElseThrow();
        pedidoInterpreteDTO.setDataPedido(taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getDataPedido());
        pedidoInterpreteDTO.setLocalTuristicoPedido(
            taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getLocalTuristicoPedido()
        );
        pedidoInterpreteDTO.setClienteName(
            taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteName()
        );
        pedidoInterpreteDTO.setClienteEmail(
            taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteEmail()
        );
        pedidoInterpreteDTO.setFreelancerNumeroReserva(
            taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancerNumeroReserva()
        );
        pedidoInterpreteDTO.setFreelancer(taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer());
        pedidoInterpreteDTO.setFreelancer(taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer());
        pedidoInterpreteDTO.setFreelancer(taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer());
        pedidoInterpreteDTO.setFreelancer(taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer());
        pedidoInterpreteDTO.setFreelancer(taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer());
        pedidoInterpreteDTO.setFreelancer(taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancer());
        pedidoInterpreteService.save(pedidoInterpreteDTO);
    }

    public void complete(TaskMelhorFreelancerContextDTO taskMelhorFreelancerContext) {
        save(taskMelhorFreelancerContext);
        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskMelhorFreelancerContext.getPedidoInterpreteProcesso().getProcessInstance().getId())
            .map(pedidoInterpreteProcessoMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskMelhorFreelancerContext.getTaskInstance(), pedidoInterpreteProcesso);
    }
}
