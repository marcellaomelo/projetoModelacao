package com.mycompany.myapp.process.pedidoInterpreteProcesso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido-interprete-processo/task-disponibilidade-freelancer")
public class TaskDisponibilidadeFreelancerController {

    private final Logger log = LoggerFactory.getLogger(TaskDisponibilidadeFreelancerController.class);

    private final TaskDisponibilidadeFreelancerService taskDisponibilidadeFreelancerService;

    public TaskDisponibilidadeFreelancerController(TaskDisponibilidadeFreelancerService taskDisponibilidadeFreelancerService) {
        this.taskDisponibilidadeFreelancerService = taskDisponibilidadeFreelancerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDisponibilidadeFreelancerContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskDisponibilidadeFreelancerContextDTO taskDisponibilidadeFreelancerContext = taskDisponibilidadeFreelancerService.loadContext(id);
        return ResponseEntity.ok(taskDisponibilidadeFreelancerContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskDisponibilidadeFreelancerContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskDisponibilidadeFreelancerContextDTO taskDisponibilidadeFreelancerContext = taskDisponibilidadeFreelancerService.claim(id);
        return ResponseEntity.ok(taskDisponibilidadeFreelancerContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskDisponibilidadeFreelancerContextDTO taskDisponibilidadeFreelancerContext) {
        log.debug(
            "REST request to complete PedidoInterpreteProcesso.TaskDisponibilidadeFreelancer {}",
            taskDisponibilidadeFreelancerContext.getTaskInstance().getId()
        );
        taskDisponibilidadeFreelancerService.complete(taskDisponibilidadeFreelancerContext);
        return ResponseEntity.noContent().build();
    }
}
