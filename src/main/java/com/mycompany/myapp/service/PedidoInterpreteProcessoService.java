package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.PedidoInterpreteProcesso;
import com.mycompany.myapp.repository.PedidoInterpreteProcessoRepository;
import com.mycompany.myapp.repository.PedidoInterpreteRepository;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessoDTO;
import com.mycompany.myapp.service.mapper.PedidoInterpreteProcessoMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.akip.domain.ProcessInstance;
import org.akip.service.ProcessInstanceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PedidoInterpreteProcesso}.
 */
@Service
@Transactional
public class PedidoInterpreteProcessoService {

    public static final String BPMN_PROCESS_DEFINITION_ID = "PedidoInterpreteProcesso";

    private final Logger log = LoggerFactory.getLogger(PedidoInterpreteProcessoService.class);

    private final ProcessInstanceService processInstanceService;

    private final PedidoInterpreteRepository pedidoInterpreteRepository;

    private final PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository;

    private final PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper;

    public PedidoInterpreteProcessoService(
        ProcessInstanceService processInstanceService,
        PedidoInterpreteRepository pedidoInterpreteRepository,
        PedidoInterpreteProcessoRepository pedidoInterpreteProcessoRepository,
        PedidoInterpreteProcessoMapper pedidoInterpreteProcessoMapper
    ) {
        this.processInstanceService = processInstanceService;
        this.pedidoInterpreteRepository = pedidoInterpreteRepository;
        this.pedidoInterpreteProcessoRepository = pedidoInterpreteProcessoRepository;
        this.pedidoInterpreteProcessoMapper = pedidoInterpreteProcessoMapper;
    }

    /**
     * Save a pedidoInterpreteProcesso.
     *
     * @param pedidoInterpreteProcessoDTO the entity to save.
     * @return the persisted entity.
     */
    public PedidoInterpreteProcessoDTO create(PedidoInterpreteProcessoDTO pedidoInterpreteProcessoDTO) {
        log.debug("Request to save PedidoInterpreteProcesso : {}", pedidoInterpreteProcessoDTO);

        PedidoInterpreteProcesso pedidoInterpreteProcesso = pedidoInterpreteProcessoMapper.toEntity(pedidoInterpreteProcessoDTO);

        //Saving the domainEntity
        pedidoInterpreteRepository.save(pedidoInterpreteProcesso.getPedidoInterprete());

        //Creating the process instance in the Camunda and setting it in the process entity
        ProcessInstance processInstance = processInstanceService.create(
            BPMN_PROCESS_DEFINITION_ID,
            "PedidoInterprete#" + pedidoInterpreteProcesso.getPedidoInterprete().getId(),
            pedidoInterpreteProcesso
        );
        pedidoInterpreteProcesso.setProcessInstance(processInstance);

        //Saving the process entity
        pedidoInterpreteProcesso = pedidoInterpreteProcessoRepository.save(pedidoInterpreteProcesso);
        return pedidoInterpreteProcessoMapper.toDto(pedidoInterpreteProcesso);
    }

    /**
     * Get all the pedidoInterpreteProcessos.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PedidoInterpreteProcessoDTO> findAll() {
        log.debug("Request to get all PedidoInterpreteProcessos");
        return pedidoInterpreteProcessoRepository
            .findAll()
            .stream()
            .map(pedidoInterpreteProcessoMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one pedidoInterpreteProcesso by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PedidoInterpreteProcessoDTO> findOne(Long id) {
        log.debug("Request to get PedidoInterpreteProcesso : {}", id);
        return pedidoInterpreteProcessoRepository.findById(id).map(pedidoInterpreteProcessoMapper::toDto);
    }

    /**
     * Get one pedidoInterpreteProcesso by id.
     *
     * @param processInstanceId the id of the processInstance associated to the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PedidoInterpreteProcessoDTO> findByProcessInstanceId(Long processInstanceId) {
        log.debug("Request to get PedidoInterpreteProcesso by  processInstanceId: {}", processInstanceId);
        return pedidoInterpreteProcessoRepository.findByProcessInstanceId(processInstanceId).map(pedidoInterpreteProcessoMapper::toDto);
    }
}
