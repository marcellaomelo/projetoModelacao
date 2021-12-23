package com.mycompany.myapp.process.pedidoInterpreteProcesso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido-interprete-processo/task-reserva-servico")
public class TaskReservaServicoController {

    private final Logger log = LoggerFactory.getLogger(TaskReservaServicoController.class);

    private final TaskReservaServicoService taskReservaServicoService;

    public TaskReservaServicoController(TaskReservaServicoService taskReservaServicoService) {
        this.taskReservaServicoService = taskReservaServicoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskReservaServicoContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskReservaServicoContextDTO taskReservaServicoContext = taskReservaServicoService.loadContext(id);
        return ResponseEntity.ok(taskReservaServicoContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskReservaServicoContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskReservaServicoContextDTO taskReservaServicoContext = taskReservaServicoService.claim(id);
        return ResponseEntity.ok(taskReservaServicoContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskReservaServicoContextDTO taskReservaServicoContext) {
        log.debug(
            "REST request to complete PedidoInterpreteProcesso.TaskReservaServico {}",
            taskReservaServicoContext.getTaskInstance().getId()
        );
        taskReservaServicoService.complete(taskReservaServicoContext);
        return ResponseEntity.noContent().build();
    }
}
