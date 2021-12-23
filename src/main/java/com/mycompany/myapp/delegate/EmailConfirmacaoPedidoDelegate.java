package com.mycompany.myapp.delegate;

import com.mycompany.myapp.service.MailService;
import com.mycompany.myapp.service.dto.PedidoInterpreteDTO;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessoDTO;
import java.util.Locale;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Component
public class EmailConfirmacaoPedidoDelegate implements JavaDelegate {

    @Autowired
    MailService mailService;

    @Autowired
    SpringTemplateEngine templateEngine;

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        PedidoInterpreteProcessoDTO pedidoInterpreteProcesso = (PedidoInterpreteProcessoDTO) delegateExecution.getVariable(
            "processInstance"
        );
        PedidoInterpreteDTO pedidoInterprete = pedidoInterpreteProcesso.getPedidoInterprete();
        String to = pedidoInterprete.getClienteEmail();
        String subject = "[AgileKip] Pede a confirmação do pedido";
        Context context = new Context(Locale.getDefault());
        context.setVariable("pedidoInterprete", pedidoInterprete);
        String content = templateEngine.process("pedidoInterpreteProcesso/pedidoInterpreteSummaryEmail", context);
        mailService.sendEmail(to, subject, content, false, true);
    }
}
