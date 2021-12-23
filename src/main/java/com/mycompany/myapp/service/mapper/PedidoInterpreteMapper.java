package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.PedidoInterpreteDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PedidoInterprete} and its DTO {@link PedidoInterpreteDTO}.
 */
@Mapper(componentModel = "spring", uses = { FreelancerMapper.class, EmpresaTerciariaMapper.class })
public interface PedidoInterpreteMapper extends EntityMapper<PedidoInterpreteDTO, PedidoInterprete> {
    @Mapping(target = "freelancer", source = "freelancer", qualifiedByName = "freelancername")
    @Mapping(target = "freelancer", source = "freelancer", qualifiedByName = "freelancerdataDisponivel")
    @Mapping(target = "freelancer", source = "freelancer", qualifiedByName = "existeFreelancerDisponivel")
    @Mapping(target = "freelancer", source = "freelancer", qualifiedByName = "existeMaisQueUmFreelancerDisponivel")
    @Mapping(target = "freelancer", source = "freelancer", qualifiedByName = "anosExperienciaFreelancer")
    @Mapping(target = "freelancer", source = "freelancer", qualifiedByName = "freelancerEscolhido")
    @Mapping(target = "freelancer", source = "freelancer", qualifiedByName = "freelancerUnicoEscolhido")
    @Mapping(target = "empresaTerciaria", source = "empresaTerciaria", qualifiedByName = "interpreteEmpresaName")
    @Mapping(target = "empresaTerciaria", source = "empresaTerciaria", qualifiedByName = "interpreteEmpresaDataDisponivel")
    @Mapping(target = "empresaTerciaria", source = "empresaTerciaria", qualifiedByName = "pedidoInterpreteEmpresa")
    PedidoInterpreteDTO toDto(PedidoInterprete s);
}
