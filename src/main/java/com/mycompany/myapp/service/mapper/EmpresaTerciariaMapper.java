package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.EmpresaTerciariaDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link EmpresaTerciaria} and its DTO {@link EmpresaTerciariaDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmpresaTerciariaMapper extends EntityMapper<EmpresaTerciariaDTO, EmpresaTerciaria> {
    @Named("interpreteEmpresaName")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "interpreteEmpresaName", source = "interpreteEmpresaName")
    EmpresaTerciariaDTO toDtoInterpreteEmpresaName(EmpresaTerciaria empresaTerciaria);

    @Named("interpreteEmpresaDataDisponivel")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "interpreteEmpresaDataDisponivel", source = "interpreteEmpresaDataDisponivel")
    EmpresaTerciariaDTO toDtoInterpreteEmpresaDataDisponivel(EmpresaTerciaria empresaTerciaria);

    @Named("pedidoInterpreteEmpresa")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "pedidoInterpreteEmpresa", source = "pedidoInterpreteEmpresa")
    EmpresaTerciariaDTO toDtoPedidoInterpreteEmpresa(EmpresaTerciaria empresaTerciaria);
}
