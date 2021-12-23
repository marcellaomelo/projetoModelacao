package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.FreelancerDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Freelancer} and its DTO {@link FreelancerDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface FreelancerMapper extends EntityMapper<FreelancerDTO, Freelancer> {
    @Named("id")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    FreelancerDTO toDtoId(Freelancer freelancer);

    @Named("existeFreelancerDisponivel")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "existeFreelancerDisponivel", source = "existeFreelancerDisponivel")
    FreelancerDTO toDtoExisteFreelancerDisponivel(Freelancer freelancer);

    @Named("existeMaisQueUmFreelancerDisponivel")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "existeMaisQueUmFreelancerDisponivel", source = "existeMaisQueUmFreelancerDisponivel")
    FreelancerDTO toDtoExisteMaisQueUmFreelancerDisponivel(Freelancer freelancer);

    @Named("anosExperienciaFreelancer")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "anosExperienciaFreelancer", source = "anosExperienciaFreelancer")
    FreelancerDTO toDtoAnosExperienciaFreelancer(Freelancer freelancer);

    @Named("freelancerEscolhido")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "freelancerEscolhido", source = "freelancerEscolhido")
    FreelancerDTO toDtoFreelancerEscolhido(Freelancer freelancer);

    @Named("freelancerUnicoEscolhido")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "freelancerUnicoEscolhido", source = "freelancerUnicoEscolhido")
    FreelancerDTO toDtoFreelancerUnicoEscolhido(Freelancer freelancer);
}
