package com.mycompany.myapp.process.pedidoInterpreteProcesso;

import com.mycompany.myapp.service.dto.PedidoInterpreteProcessoDTO;
import org.akip.service.dto.TaskInstanceDTO;

public class TaskReservaServicoContextDTO {

    private PedidoInterpreteProcessoDTO pedidoInterpreteProcesso;
    private TaskInstanceDTO taskInstance;

    public PedidoInterpreteProcessoDTO getPedidoInterpreteProcesso() {
        return pedidoInterpreteProcesso;
    }

    public void setPedidoInterpreteProcesso(PedidoInterpreteProcessoDTO pedidoInterpreteProcesso) {
        this.pedidoInterpreteProcesso = pedidoInterpreteProcesso;
    }

    public TaskInstanceDTO getTaskInstance() {
        return taskInstance;
    }

    public void setTaskInstance(TaskInstanceDTO taskInstance) {
        this.taskInstance = taskInstance;
    }
}
