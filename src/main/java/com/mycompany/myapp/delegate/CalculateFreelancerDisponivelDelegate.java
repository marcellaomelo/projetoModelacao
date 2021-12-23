package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.dto.PedidoInterpreteProcessoDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component
public class CalculateFreelancerDisponivelDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = (PedidoInterpreteProcessoDTO) delegateExecution.getVariable(
            "processInstance"
        );
        Boolean freelancerDisponivel = pedidoInterpreteProcesso.getFreelancer().getExisteFreelancerDisponivel() == true;
        delegateExecution.setVariable("freelancerDisponivel", freelancerDisponivel);
    }
}
