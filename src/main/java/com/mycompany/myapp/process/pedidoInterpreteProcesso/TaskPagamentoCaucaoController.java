package com.mycompany.myapp.process.pedidoInterpreteProcesso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido-interprete-processo/task-pagamento-caucao")
public class TaskPagamentoCaucaoController {

    private final Logger log = LoggerFactory.getLogger(TaskPagamentoCaucaoController.class);

    private final TaskPagamentoCaucaoService taskPagamentoCaucaoService;

    public TaskPagamentoCaucaoController(TaskPagamentoCaucaoService taskPagamentoCaucaoService) {
        this.taskPagamentoCaucaoService = taskPagamentoCaucaoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskPagamentoCaucaoContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPagamentoCaucaoContextDTO taskPagamentoCaucaoContext = taskPagamentoCaucaoService.loadContext(id);
        return ResponseEntity.ok(taskPagamentoCaucaoContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskPagamentoCaucaoContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskPagamentoCaucaoContextDTO taskPagamentoCaucaoContext = taskPagamentoCaucaoService.claim(id);
        return ResponseEntity.ok(taskPagamentoCaucaoContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskPagamentoCaucaoContextDTO taskPagamentoCaucaoContext) {
        log.debug(
            "REST request to complete PedidoInterpreteProcesso.TaskPagamentoCaucao {}",
            taskPagamentoCaucaoContext.getTaskInstance().getId()
        );
        taskPagamentoCaucaoService.complete(taskPagamentoCaucaoContext);
        return ResponseEntity.noContent().build();
    }
}
