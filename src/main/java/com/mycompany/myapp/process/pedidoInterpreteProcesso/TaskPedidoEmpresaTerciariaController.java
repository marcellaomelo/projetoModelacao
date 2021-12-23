package com.mycompany.myapp.process.pedidoInterpreteProcesso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido-interprete-processo/task-pedido-empresa-terciaria")
public class TaskPedidoEmpresaTerciariaController {

    private final Logger log = LoggerFactory.getLogger(TaskPedidoEmpresaTerciariaController.class);

    private final TaskPedidoEmpresaTerciariaService taskPedidoEmpresaTerciariaService;

    public TaskPedidoEmpresaTerciariaController(TaskPedidoEmpresaTerciariaService taskPedidoEmpresaTerciariaService) {
        this.taskPedidoEmpresaTerciariaService = taskPedidoEmpresaTerciariaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskPedidoEmpresaTerciariaContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPedidoEmpresaTerciariaContextDTO taskPedidoEmpresaTerciariaContext = taskPedidoEmpresaTerciariaService.loadContext(id);
        return ResponseEntity.ok(taskPedidoEmpresaTerciariaContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskPedidoEmpresaTerciariaContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPedidoEmpresaTerciariaContextDTO taskPedidoEmpresaTerciariaContext = taskPedidoEmpresaTerciariaService.claim(id);
        return ResponseEntity.ok(taskPedidoEmpresaTerciariaContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskPedidoEmpresaTerciariaContextDTO taskPedidoEmpresaTerciariaContext) {
        log.debug(
            "REST request to complete PedidoInterpreteProcesso.TaskPedidoEmpresaTerciaria {}",
            taskPedidoEmpresaTerciariaContext.getTaskInstance().getId()
        );
        taskPedidoEmpresaTerciariaService.complete(taskPedidoEmpresaTerciariaContext);
        return ResponseEntity.noContent().build();
    }
}
