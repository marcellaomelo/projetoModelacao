package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.DataService;
import com.mycompany.myapp.service.FreelancerAvailabilityService;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessoDTO;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GerarPedidoInterpreteEmpresaTerciariaDelegate implements JavaDelegate {

    @Autowired
    FreelancerAvailabilityService freelancerAvailabilityService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = (PedidoInterpreteProcessoDTO) delegateExecution.getVariable(
            "processInstance"
        );

        //Confirm freelancer availability
        freelancerAvailabilityService.confirmFreelancerAvailability(pedidoInterpreteProcesso.getPedidoInterprete().isFreelancerAvailable());
    }
}
