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
public class TaskPagamentoCaucaoService {

    private final TaskInstanceService taskInstanceService;

    private final PedidoInterpreteService pedidoInterpreteService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskPagamentoCaucaoMapper taskPagamentoCaucaoMapper;

    private final PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper;

    public TaskPagamentoCaucaoService(
        TaskInstanceService taskInstanceService,
        PedidoInterpreteService pedidoInterpreteService,
        TaskInstanceRepository taskInstanceRepository,
        PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskPagamentoCaucaoMapper taskPagamentoCaucaoMapper,
        PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.pedidoInterpreteService = pedidoInterpreteService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.pedidoInterpreteProcessoRepository = pedidoInterpreteProcessoRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskPagamentoCaucaoMapper = taskPagamentoCaucaoMapper;
        this.pedidoInterpreteProcessoMapper = pedidoInterpreteProcessoMapper;
    }

    public TaskPagamentoCaucaoContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskPagamentoCaucaoMapper::toPedidoInterpreteProcessoDTO)
            .orElseThrow();

        TaskPagamentoCaucaoContextDTO taskPagamentoCaucaoContext = new TaskPagamentoCaucaoContextDTO();
        taskPagamentoCaucaoContext.setTaskInstance(taskInstanceDTO);
        taskPagamentoCaucaoContext.setPedidoInterpreteProcesso(pedidoInterpreteProcesso);

        return taskPagamentoCaucaoContext;
    }

    public TaskPagamentoCaucaoContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskPagamentoCaucaoContextDTO taskPagamentoCaucaoContext) {
        PedidoInterpreteDTO pedidoInterpreteDTO = pedidoInterpreteService
            .findOne(taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getId())
            .orElseThrow();
        pedidoInterpreteDTO.setDataPedido(taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getDataPedido());
        pedidoInterpreteDTO.setLocalTuristicoPedido(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getLocalTuristicoPedido()
        );
        pedidoInterpreteDTO.setClienteName(taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteName());
        pedidoInterpreteDTO.setClienteEmail(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteEmail()
        );
        pedidoInterpreteDTO.setFreelancerNumeroReserva(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancerNumeroReserva()
        );
        pedidoInterpreteDTO.setEmpresaTerciariaNumeroReserva(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciariaNumeroReserva()
        );
        pedidoInterpreteDTO.setPrecoReserva(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getPrecoReserva()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteService.save(pedidoInterpreteDTO);
    }

    public void complete(TaskPagamentoCaucaoContextDTO taskPagamentoCaucaoContext) {
        save(taskPagamentoCaucaoContext);
        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskPagamentoCaucaoContext.getPedidoInterpreteProcesso().getProcessInstance().getId())
            .map(pedidoInterpreteProcessoMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskPagamentoCaucaoContext.getTaskInstance(), pedidoInterpreteProcesso);
    }
}
