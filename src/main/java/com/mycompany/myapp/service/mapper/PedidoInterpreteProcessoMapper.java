package com.mycompany.myapp.service.mapper;

import com.mycompany.myapp.domain.*;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessoDTO;
import org.akip.service.mapper.ProcessInstanceMapper;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PedidoInterpreteProcesso} and its DTO {@link PedidoInterpreteProcessoDTO}.
 */
@Mapper(componentModel = "spring", uses = { ProcessInstanceMapper.class, PedidoInterpreteMapper.class })
public interface PedidoInterpreteProcessoMapper extends EntityMapper<PedidoInterpreteProcessoDTO, PedidoInterpreteProcesso> {
    @Mapping(target = "processInstance", source = "processInstance")
    @Mapping(target = "pedidoInterprete", source = "pedidoInterprete")
    PedidoInterpreteProcessoDTO toDto(PedidoInterpreteProcesso s);
}
