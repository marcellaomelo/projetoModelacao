package com.mycompany.myapp.process.pedidoInterpreteProcesso;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedido-interprete-processo/task-melhor-freelancer")
public class TaskMelhorFreelancerController {

    private final Logger log = LoggerFactory.getLogger(TaskMelhorFreelancerController.class);

    private final TaskMelhorFreelancerService taskMelhorFreelancerService;

    public TaskMelhorFreelancerController(TaskMelhorFreelancerService taskMelhorFreelancerService) {
        this.taskMelhorFreelancerService = taskMelhorFreelancerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskMelhorFreelancerContextDTO> loadContext(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskMelhorFreelancerContextDTO taskMelhorFreelancerContext = taskMelhorFreelancerService.loadContext(id);
        return ResponseEntity.ok(taskMelhorFreelancerContext);
    }

    @GetMapping("/{id}/claim")
    public ResponseEntity<TaskMelhorFreelancerContextDTO> claim(@PathVariable Long id) {
        log.debug("REST request to load the context of task hotel {}", id);
        TaskMelhorFreelancerContextDTO taskMelhorFreelancerContext = taskMelhorFreelancerService.claim(id);
        return ResponseEntity.ok(taskMelhorFreelancerContext);
    }

    @PostMapping("/complete")
    public ResponseEntity<Void> complete(@RequestBody TaskMelhorFreelancerContextDTO taskMelhorFreelancerContext) {
        log.debug(
            "REST request to complete PedidoInterpreteProcesso.TaskMelhorFreelancer {}",
            taskMelhorFreelancerContext.getTaskInstance().getId()
        );
        taskMelhorFreelancerService.complete(taskMelhorFreelancerContext);
        return ResponseEntity.noContent().build();
    }
}
