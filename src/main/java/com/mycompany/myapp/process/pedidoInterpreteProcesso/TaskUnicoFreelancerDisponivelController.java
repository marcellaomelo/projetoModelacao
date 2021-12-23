package com.mycompany.myapp.process.pedidoInterpreteProcesso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido-interprete-processo/task-unico-freelancer-disponivel")
public class TaskUnicoFreelancerDisponivelController {

    private final Logger log = LoggerFactory.getLogger(TaskUnicoFreelancerDisponivelController.class);

    private final TaskUnicoFreelancerDisponivelService taskUnicoFreelancerDisponivelService;

    public TaskUnicoFreelancerDisponivelController(TaskUnicoFreelancerDisponivelService taskUnicoFreelancerDisponivelService) {
        this.taskUnicoFreelancerDisponivelService = taskUnicoFreelancerDisponivelService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskUnicoFreelancerDisponivelContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUnicoFreelancerDisponivelContextDTO taskUnicoFreelancerDisponivelContext = taskUnicoFreelancerDisponivelService.loadContext(id);
        return ResponseEntity.ok(taskUnicoFreelancerDisponivelContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskUnicoFreelancerDisponivelContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskUnicoFreelancerDisponivelContextDTO taskUnicoFreelancerDisponivelContext = taskUnicoFreelancerDisponivelService.claim(id);
        return ResponseEntity.ok(taskUnicoFreelancerDisponivelContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskUnicoFreelancerDisponivelContextDTO taskUnicoFreelancerDisponivelContext) {
        log.debug(
            "REST request to complete PedidoInterpreteProcesso.TaskUnicoFreelancerDisponivel {}",
            taskUnicoFreelancerDisponivelContext.getTaskInstance().getId()
        );
        taskUnicoFreelancerDisponivelService.complete(taskUnicoFreelancerDisponivelContext);
        return ResponseEntity.noContent().build();
    }
}
