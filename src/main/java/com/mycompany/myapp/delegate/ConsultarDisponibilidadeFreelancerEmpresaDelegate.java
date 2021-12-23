package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.DataService;
import com.mycompany.myapp.service.FreelancerAvailabilityService;
import com.mycompany.myapp.service.LocationService;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessoDTO;
import java.time.LocalDate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConsultarDisponibilidadeFreelancerEmpresaDelegate implements JavaDelegate {

    @Autowired
    DataService dataService;

    @Autowired
    LocationService locationService;

    @Autowired
    FreelancerAvailabilityService freelancerAvailabilityService;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = (PedidoInterpreteProcessoDTO) delegateExecution.getVariable(
            "processInstance"
        );

        //Confirming the request data
        dataService.confirmData(pedidoInterpreteProcesso.getPedidoInterprete().getDataPedido());

        //Confirm location
        locationService.confirmLocation(pedidoInterpreteProcesso.getPedidoInterprete().getLocalTuristicoPedido());

        //Confirm freelancer availability
        freelancerAvailabilityService.confirmFreelancerAvailability(pedidoInterpreteProcesso.getPedidoInterprete().isFreelancerAvailable());
    }
}
