package com.mycompany.myapp.service;

import com.mycompany.myapp.domain.Freelancer;
import com.mycompany.myapp.repository.FreelancerRepository;
import com.mycompany.myapp.service.dto.FreelancerDTO;
import com.mycompany.myapp.service.mapper.FreelancerMapper;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Freelancer}.
 */
@Service
@Transactional
public class FreelancerService {

    private final Logger log = LoggerFactory.getLogger(FreelancerService.class);

    private final FreelancerRepository freelancerRepository;

    private final FreelancerMapper freelancerMapper;

    public FreelancerService(FreelancerRepository freelancerRepository, FreelancerMapper freelancerMapper) {
        this.freelancerRepository = freelancerRepository;
        this.freelancerMapper = freelancerMapper;
    }

    /**
     * Save a freelancer.
     *
     * @param freelancerDTO the entity to save.
     * @return the persisted entity.
     */
    public FreelancerDTO save(FreelancerDTO freelancerDTO) {
        log.debug("Request to save Freelancer : {}", freelancerDTO);
        Freelancer freelancer = freelancerMapper.toEntity(freelancerDTO);
        freelancer = freelancerRepository.save(freelancer);
        return freelancerMapper.toDto(freelancer);
    }

    /**
     * Partially update a freelancer.
     *
     * @param freelancerDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<FreelancerDTO> partialUpdate(FreelancerDTO freelancerDTO) {
        log.debug("Request to partially update Freelancer : {}", freelancerDTO);

        return freelancerRepository
            .findById(freelancerDTO.getId())
            .map(
                existingFreelancer -> {
                    freelancerMapper.partialUpdate(existingFreelancer, freelancerDTO);
                    return existingFreelancer;
                }
            )
            .map(freelancerRepository::save)
            .map(freelancerMapper::toDto);
    }

    /**
     * Get all the freelancers.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<FreelancerDTO> findAll() {
        log.debug("Request to get all Freelancers");
        return freelancerRepository.findAll().stream().map(freelancerMapper::toDto).collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one freelancer by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<FreelancerDTO> findOne(Long id) {
        log.debug("Request to get Freelancer : {}", id);
        return freelancerRepository.findById(id).map(freelancerMapper::toDto);
    }

    /**
     * Delete the freelancer by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Freelancer : {}", id);
        freelancerRepository.deleteById(id);
    }
}
