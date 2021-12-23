package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.EmpresaTerciaria;
import com.mycompany.myapp.repository.EmpresaTerciariaRepository;
import com.mycompany.myapp.service.dto.EmpresaTerciariaDTO;
import com.mycompany.myapp.service.mapper.EmpresaTerciariaMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link EmpresaTerciaria}.
 */
@Service
@Transactional
public class EmpresaTerciariaService {

    private final Logger log = LoggerFactory.getLogger(EmpresaTerciariaService.class);

    private final EmpresaTerciariaRepository empresaTerciariaRepository;

    private final EmpresaTerciariaMapper empresaTerciariaMapper;

    public EmpresaTerciariaService(EmpresaTerciariaRepository empresaTerciariaRepository, EmpresaTerciariaMapper empresaTerciariaMapper) {
        this.empresaTerciariaRepository = empresaTerciariaRepository;
        this.empresaTerciariaMapper = empresaTerciariaMapper;
    }

    /**
     * Save a empresaTerciaria.
     *
     * @param empresaTerciariaDTO the entity to save.
     * @return the persisted entity.
     */
    public EmpresaTerciariaDTO save(EmpresaTerciariaDTO empresaTerciariaDTO) {
        log.debug("Request to save EmpresaTerciaria : {}", empresaTerciariaDTO);
        EmpresaTerciaria empresaTerciaria = empresaTerciariaMapper.toEntity(empresaTerciariaDTO);
        empresaTerciaria = empresaTerciariaRepository.save(empresaTerciaria);
        return empresaTerciariaMapper.toDto(empresaTerciaria);
    }

    /**
     * Partially update a empresaTerciaria.
     *
     * @param empresaTerciariaDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<EmpresaTerciariaDTO> partialUpdate(EmpresaTerciariaDTO empresaTerciariaDTO) {
        log.debug("Request to partially update EmpresaTerciaria : {}", empresaTerciariaDTO);

        return empresaTerciariaRepository
            .findById(empresaTerciariaDTO.getId())
            .map(
                existingEmpresaTerciaria -> {
                    empresaTerciariaMapper.partialUpdate(existingEmpresaTerciaria, empresaTerciariaDTO);
                    return existingEmpresaTerciaria;
                }
            )
            .map(empresaTerciariaRepository::save)
            .map(empresaTerciariaMapper::toDto);
    }

    /**
     * Get all the empresaTerciarias.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<EmpresaTerciariaDTO> findAll() {
        log.debug("Request to get all EmpresaTerciarias");
        return empresaTerciariaRepository
            .findAll()
            .stream()
            .map(empresaTerciariaMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one empresaTerciaria by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<EmpresaTerciariaDTO> findOne(Long id) {
        log.debug("Request to get EmpresaTerciaria : {}", id);
        return empresaTerciariaRepository.findById(id).map(empresaTerciariaMapper::toDto);
    }

    /**
     * Delete the empresaTerciaria by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete EmpresaTerciaria : {}", id);
        empresaTerciariaRepository.deleteById(id);
    }
}
