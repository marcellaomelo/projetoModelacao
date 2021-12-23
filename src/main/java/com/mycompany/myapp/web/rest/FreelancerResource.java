package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.FreelancerRepository;
import com.mycompany.myapp.service.FreelancerService;
import com.mycompany.myapp.service.dto.FreelancerDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.Freelancer}.
 */
@RestController
@RequestMapping("/api")
public class FreelancerResource {

    private final Logger log = LoggerFactory.getLogger(FreelancerResource.class);

    private static final String ENTITY_NAME = "freelancer";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final FreelancerService freelancerService;

    private final FreelancerRepository freelancerRepository;

    public FreelancerResource(FreelancerService freelancerService, FreelancerRepository freelancerRepository) {
        this.freelancerService = freelancerService;
        this.freelancerRepository = freelancerRepository;
    }

    /**
     * {@code POST  /freelancers} : Create a new freelancer.
     *
     * @param freelancerDTO the freelancerDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new freelancerDTO, or with status {@code 400 (Bad Request)} if the freelancer has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/freelancers")
    public ResponseEntity<FreelancerDTO> createFreelancer(@RequestBody FreelancerDTO freelancerDTO) throws URISyntaxException {
        log.debug("REST request to save Freelancer : {}", freelancerDTO);
        if (freelancerDTO.getId() != null) {
            throw new BadRequestAlertException("A new freelancer cannot already have an ID", ENTITY_NAME, "idexists");
        }
        FreelancerDTO result = freelancerService.save(freelancerDTO);
        return ResponseEntity
            .created(new URI("/api/freelancers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /freelancers/:id} : Updates an existing freelancer.
     *
     * @param id the id of the freelancerDTO to save.
     * @param freelancerDTO the freelancerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated freelancerDTO,
     * or with status {@code 400 (Bad Request)} if the freelancerDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the freelancerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/freelancers/{id}")
    public ResponseEntity<FreelancerDTO> updateFreelancer(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody FreelancerDTO freelancerDTO
    ) throws URISyntaxException {
        log.debug("REST request to update Freelancer : {}, {}", id, freelancerDTO);
        if (freelancerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, freelancerDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!freelancerRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        FreelancerDTO result = freelancerService.save(freelancerDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, freelancerDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /freelancers/:id} : Partial updates given fields of an existing freelancer, field will ignore if it is null
     *
     * @param id the id of the freelancerDTO to save.
     * @param freelancerDTO the freelancerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated freelancerDTO,
     * or with status {@code 400 (Bad Request)} if the freelancerDTO is not valid,
     * or with status {@code 404 (Not Found)} if the freelancerDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the freelancerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/freelancers/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<FreelancerDTO> partialUpdateFreelancer(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody FreelancerDTO freelancerDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update Freelancer partially : {}, {}", id, freelancerDTO);
        if (freelancerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, freelancerDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!freelancerRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<FreelancerDTO> result = freelancerService.partialUpdate(freelancerDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, freelancerDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /freelancers} : get all the freelancers.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of freelancers in body.
     */
    @GetMapping("/freelancers")
    public List<FreelancerDTO> getAllFreelancers() {
        log.debug("REST request to get all Freelancers");
        return freelancerService.findAll();
    }

    /**
     * {@code GET  /freelancers/:id} : get the "id" freelancer.
     *
     * @param id the id of the freelancerDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the freelancerDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/freelancers/{id}")
    public ResponseEntity<FreelancerDTO> getFreelancer(@PathVariable Long id) {
        log.debug("REST request to get Freelancer : {}", id);
        Optional<FreelancerDTO> freelancerDTO = freelancerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(freelancerDTO);
    }

    /**
     * {@code DELETE  /freelancers/:id} : delete the "id" freelancer.
     *
     * @param id the id of the freelancerDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/freelancers/{id}")
    public ResponseEntity<Void> deleteFreelancer(@PathVariable Long id) {
        log.debug("REST request to delete Freelancer : {}", id);
        freelancerService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
