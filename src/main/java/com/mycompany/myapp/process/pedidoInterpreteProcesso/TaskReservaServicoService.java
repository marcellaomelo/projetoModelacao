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
public class TaskReservaServicoService {

    private final TaskInstanceService taskInstanceService;

    private final PedidoInterpreteService pedidoInterpreteService;

    private final TaskInstanceRepository taskInstanceRepository;

    private final PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository;

    private final TaskInstanceMapper taskInstanceMapper;

    private final TaskReservaServicoMapper taskReservaServicoMapper;

    private final PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper;

    public TaskReservaServicoService(
        TaskInstanceService taskInstanceService,
        PedidoInterpreteService pedidoInterpreteService,
        TaskInstanceRepository taskInstanceRepository,
        PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository,
        TaskInstanceMapper taskInstanceMapper,
        TaskReservaServicoMapper taskReservaServicoMapper,
        PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper
    ) {
        this.taskInstanceService = taskInstanceService;
        this.pedidoInterpreteService = pedidoInterpreteService;
        this.taskInstanceRepository = taskInstanceRepository;
        this.pedidoInterpreteProcessoRepository = pedidoInterpreteProcessoRepository;
        this.taskInstanceMapper = taskInstanceMapper;
        this.taskReservaServicoMapper = taskReservaServicoMapper;
        this.pedidoInterpreteProcessoMapper = pedidoInterpreteProcessoMapper;
    }

    public TaskReservaServicoContextDTO loadContext(Long taskInstanceId) {
        TaskInstanceDTO taskInstanceDTO = taskInstanceRepository
            .findById(taskInstanceId)
            .map(taskInstanceMapper::toDTOLoadTaskContext)
            .orElseThrow();

        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskInstanceDTO.getProcessInstance().getId())
            .map(taskReservaServicoMapper::toPedidoInterpreteProcessoDTO)
            .orElseThrow();

        TaskReservaServicoContextDTO taskReservaServicoContext = new TaskReservaServicoContextDTO();
        taskReservaServicoContext.setTaskInstance(taskInstanceDTO);
        taskReservaServicoContext.setPedidoInterpreteProcesso(pedidoInterpreteProcesso);

        return taskReservaServicoContext;
    }

    public TaskReservaServicoContextDTO claim(Long taskInstanceId) {
        taskInstanceService.claim(taskInstanceId);
        return loadContext(taskInstanceId);
    }

    public void save(TaskReservaServicoContextDTO taskReservaServicoContext) {
        PedidoInterpreteDTO pedidoInterpreteDTO = pedidoInterpreteService
            .findOne(taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getId())
            .orElseThrow();
        pedidoInterpreteDTO.setDataPedido(taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getDataPedido());
        pedidoInterpreteDTO.setLocalTuristicoPedido(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getLocalTuristicoPedido()
        );
        pedidoInterpreteDTO.setClienteName(taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteName());
        pedidoInterpreteDTO.setClienteEmail(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getClienteEmail()
        );
        pedidoInterpreteDTO.setFreelancerNumeroReserva(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getFreelancerNumeroReserva()
        );
        pedidoInterpreteDTO.setEmpresaTerciariaNumeroReserva(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciariaNumeroReserva()
        );
        pedidoInterpreteDTO.setPrecoReserva(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getPrecoReserva()
        );
        pedidoInterpreteDTO.setReservarServico(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getReservarServico()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteDTO.setEmpresaTerciaria(
            taskReservaServicoContext.getPedidoInterpreteProcesso().getPedidoInterprete().getEmpresaTerciaria()
        );
        pedidoInterpreteService.save(pedidoInterpreteDTO);
    }

    public void complete(TaskReservaServicoContextDTO taskReservaServicoContext) {
        save(taskReservaServicoContext);
        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository
            .findByProcessInstanceId(taskReservaServicoContext.getPedidoInterpreteProcesso().getProcessInstance().getId())
            .map(pedidoInterpreteProcessoMapper::toDto)
            .orElseThrow();
        taskInstanceService.complete(taskReservaServicoContext.getTaskInstance(), pedidoInterpreteProcesso);
    }
}
