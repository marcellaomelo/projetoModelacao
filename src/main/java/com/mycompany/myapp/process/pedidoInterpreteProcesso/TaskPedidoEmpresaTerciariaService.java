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
public class TaskPedidoEmpresaTerciariaService {

    private final TaskInstanceService taskInstanceService;

    private final PedidoInterpreteService pedidoInterpreteService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskPedidoEmpresaTerciariaMapper taskPedidoEmpresaTerciariaMapper;

    private final PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper;

    public TaskPedidoEmpresaTerciariaService(
        TaskInstanceService taskInstanceService,
        PedidoInterpreteService pedidoInterpreteService,
        TaskInstanceRepository taskInstanceRepository,
        PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskPedidoEmpresaTerciariaMapper taskPedidoEmpresaTerciariaMapper,
        PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.pedidoInterpreteService = pedidoInterpreteService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.pedidoInterpreteProcessoRepository = pedidoInterpreteProcessoRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskPedidoEmpresaTerciariaMapper = taskPedidoEmpresaTerciariaMapper;
        this.pedidoInterpreteProcessoMapper = pedidoInterpreteProcessoMapper;
    }

    public TaskPedidoEmpresaTerciariaContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskPedidoEmpresaTerciariaMapper::toPedidoInterpreteProcessoDTO)
            .orElseThrow();

        TaskPedidoEmpresaTerciariaContextDTO taskPedidoEmpresaTerciariaContext = new TaskPedidoEmpresaTerciariaContextDTO();
        taskPedidoEmpresaTerciariaContext.setTaskInstance(taskInstanceDTO);
        taskPedidoEmpresaTerciariaContext.setPedidoInterpreteProcesso(pedidoInterpreteProcesso);

        return taskPedidoEmpresaTerciariaContext;
    }

    public TaskPedidoEmpresaTerciariaContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskPedidoEmpresaTerciariaContextDTO taskPedidoEmpresaTerciariaContext) {
        PedidoInterpreteDTO pedidoInterpreteDTO = pedidoInterpreteService
            .findOne(taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getId())
            .orElseThrow();
        pedidoInterpreteDTO.setDataPedido(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getDataPedido()
        );
        pedidoInterpreteDTO.setLocalTuristicoPedido(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getLocalTuristicoPedido()
        );
        pedidoInterpreteDTO.setClienteName(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteName()
        );
        pedidoInterpreteDTO.setClienteEmail(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteEmail()
        );
        pedidoInterpreteDTO.setFreelancerNumeroReserva(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancerNumeroReserva()
        );
        pedidoInterpreteDTO.setEmpresaTerciariaNumeroReserva(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciariaNumeroReserva()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteService.save(pedidoInterpreteDTO);
    }

    public void complete(TaskPedidoEmpresaTerciariaContextDTO taskPedidoEmpresaTerciariaContext) {
        save(taskPedidoEmpresaTerciariaContext);
        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskPedidoEmpresaTerciariaContext.getPedidoInterpreteProcesso().getProcessInstance().getId())
            .map(pedidoInterpreteProcessoMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskPedidoEmpresaTerciariaContext.getTaskInstance(), pedidoInterpreteProcesso);
    }
}
