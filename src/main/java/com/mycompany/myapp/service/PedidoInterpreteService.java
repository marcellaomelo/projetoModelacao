package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.PedidoInterprete;
import com.mycompany.myapp.repository.PedidoInterpreteRepository;
import com.mycompany.myapp.service.dto.PedidoInterpreteDTO;
import com.mycompany.myapp.service.mapper.PedidoInterpreteMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link PedidoInterprete}.
 */
@Service
@Transactional
public class PedidoInterpreteService {

    private final Logger log = LoggerFactory.getLogger(PedidoInterpreteService.class);

    private final PedidoInterpreteRepository pedidoInterpreteRepository;

    private final PedidoInterpreteMapper pedidoInterpreteMapper;

    public PedidoInterpreteService(PedidoInterpreteRepository pedidoInterpreteRepository, PedidoInterpreteMapper pedidoInterpreteMapper) {
        this.pedidoInterpreteRepository = pedidoInterpreteRepository;
        this.pedidoInterpreteMapper = pedidoInterpreteMapper;
    }

    /**
     * Save a pedidoInterprete.
     *
     * @param pedidoInterpreteDTO the entity to save.
     * @return the persisted entity.
     */
    public PedidoInterpreteDTO save(PedidoInterpreteDTO pedidoInterpreteDTO) {
        log.debug("Request to save PedidoInterprete : {}", pedidoInterpreteDTO);
        PedidoInterprete pedidoInterprete = pedidoInterpreteMapper.toEntity(pedidoInterpreteDTO);
        pedidoInterprete = pedidoInterpreteRepository.save(pedidoInterprete);
        return pedidoInterpreteMapper.toDto(pedidoInterprete);
    }

    /**
     * Partially update a pedidoInterprete.
     *
     * @param pedidoInterpreteDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<PedidoInterpreteDTO> partialUpdate(PedidoInterpreteDTO pedidoInterpreteDTO) {
        log.debug("Request to partially update PedidoInterprete : {}", pedidoInterpreteDTO);

        return pedidoInterpreteRepository
            .findById(pedidoInterpreteDTO.getId())
            .map(
                existingPedidoInterprete -> {
                    pedidoInterpreteMapper.partialUpdate(existingPedidoInterprete, pedidoInterpreteDTO);
                    return existingPedidoInterprete;
                }
            )
            .map(pedidoInterpreteRepository::save)
            .map(pedidoInterpreteMapper::toDto);
    }

    /**
     * Get all the pedidoInterpretes.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<PedidoInterpreteDTO> findAll() {
        log.debug("Request to get all PedidoInterpretes");
        return pedidoInterpreteRepository
            .findAll()
            .stream()
            .map(pedidoInterpreteMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one pedidoInterprete by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PedidoInterpreteDTO> findOne(Long id) {
        log.debug("Request to get PedidoInterprete : {}", id);
        return pedidoInterpreteRepository.findById(id).map(pedidoInterpreteMapper::toDto);
    }

    /**
     * Delete the pedidoInterprete by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PedidoInterprete : {}", id);
        pedidoInterpreteRepository.deleteById(id);
    }
}
