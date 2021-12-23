package com.mycompany.myapp.process.pedidoInterpreteProcesso;

import com.mycompany.myapp.domain.EmpresaTerciaria;
import com.mycompany.myapp.domain.EmpresaTerciaria;
import com.mycompany.myapp.domain.EmpresaTerciaria;
import com.mycompany.myapp.domain.Freelancer;
import com.mycompany.myapp.domain.Freelancer;
import com.mycompany.myapp.domain.Freelancer;
import com.mycompany.myapp.domain.Freelancer;
import com.mycompany.myapp.domain.Freelancer;
import com.mycompany.myapp.domain.Freelancer;
import com.mycompany.myapp.domain.PedidoInterprete;
import com.mycompany.myapp.domain.PedidoInterpreteProcesso;
import com.mycompany.myapp.service.dto.EmpresaTerciariaDTO;
import com.mycompany.myapp.service.dto.EmpresaTerciariaDTO;
import com.mycompany.myapp.service.dto.EmpresaTerciariaDTO;
import com.mycompany.myapp.service.dto.FreelancerDTO;
import com.mycompany.myapp.service.dto.FreelancerDTO;
import com.mycompany.myapp.service.dto.FreelancerDTO;
import com.mycompany.myapp.service.dto.FreelancerDTO;
import com.mycompany.myapp.service.dto.FreelancerDTO;
import com.mycompany.myapp.service.dto.FreelancerDTO;
import com.mycompany.myapp.service.dto.PedidoInterpreteDTO;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessoDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class })
public interface TaskPagamentoCaucaoMapper {
    @Mapping(target = "processInstance", source = "processInstance", qualifiedByName = "loadTaskContext")
    PedidoInterpreteProcessoDTO toPedidoInterpreteProcessoDTO(PedidoInterpreteProcesso pedidoInterpreteProcesso);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "dataPedido", source = "dataPedido")
    @Mapping(target = "localTuristicoPedido", source = "localTuristicoPedido")
    @Mapping(target = "clienteName", source = "clienteName")
    @Mapping(target = "clienteEmail", source = "clienteEmail")
    @Mapping(target = "freelancerNumeroReserva", source = "freelancerNumeroReserva")
    @Mapping(target = "empresaTerciariaNumeroReserva", source = "empresaTerciariaNumeroReserva")
    @Mapping(target = "precoReserva", source = "precoReserva")
    @Mapping(target = "freelancer", source = "freelancer")
    @Mapping(target = "freelancer", source = "freelancer")
    @Mapping(target = "freelancer", source = "freelancer")
    @Mapping(target = "freelancer", source = "freelancer")
    @Mapping(target = "freelancer", source = "freelancer")
    @Mapping(target = "freelancer", source = "freelancer")
    @Mapping(target = "empresaTerciaria", source = "empresaTerciaria")
    @Mapping(target = "empresaTerciaria", source = "empresaTerciaria")
    @Mapping(target = "empresaTerciaria", source = "empresaTerciaria")
    PedidoInterpreteDTO toPedidoInterpreteDTO(PedidoInterprete pedidoInterprete);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "freelancername", source = "freelancername")
    FreelancerDTO toFreelancerDTO(Freelancer freelancername);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "freelancerdataDisponivel", source = "freelancerdataDisponivel")
    FreelancerDTO toFreelancerDTO(Freelancer freelancerdataDisponivel);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "existeFreelancerDisponivel", source = "existeFreelancerDisponivel")
    FreelancerDTO toFreelancerDTO(Freelancer existeFreelancerDisponivel);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "existeMaisQueUmFreelancerDisponivel", source = "existeMaisQueUmFreelancerDisponivel")
    FreelancerDTO toFreelancerDTO(Freelancer existeMaisQueUmFreelancerDisponivel);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "anosExperienciaFreelancer", source = "anosExperienciaFreelancer")
    FreelancerDTO toFreelancerDTO(Freelancer anosExperienciaFreelancer);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "freelancerEscolhido", source = "freelancerEscolhido")
    FreelancerDTO toFreelancerDTO(Freelancer freelancerEscolhido);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "interpreteEmpresaName", source = "interpreteEmpresaName")
    EmpresaTerciariaDTO toEmpresaTerciariaDTO(EmpresaTerciaria interpreteEmpresaName);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "interpreteEmpresaDataDisponivel", source = "interpreteEmpresaDataDisponivel")
    EmpresaTerciariaDTO toEmpresaTerciariaDTO(EmpresaTerciaria interpreteEmpresaDataDisponivel);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "pedidoInterpreteEmpresa", source = "pedidoInterpreteEmpresa")
    EmpresaTerciariaDTO toEmpresaTerciariaDTO(EmpresaTerciaria pedidoInterpreteEmpresa);
}
