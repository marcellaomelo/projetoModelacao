package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.EmpresaTerciariaRepository;
import com.mycompany.myapp.service.EmpresaTerciariaService;
import com.mycompany.myapp.service.dto.EmpresaTerciariaDTO;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.EmpresaTerciaria}.
 */
@RestController
@RequestMapping("/api")
public class EmpresaTerciariaResource {

    private final Logger log = LoggerFactory.getLogger(EmpresaTerciariaResource.class);

    private static final String ENTITY_NAME = "empresaTerciaria";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final EmpresaTerciariaService empresaTerciariaService;

    private final EmpresaTerciariaRepository empresaTerciariaRepository;

    public EmpresaTerciariaResource(
        EmpresaTerciariaService empresaTerciariaService,
        EmpresaTerciariaRepository empresaTerciariaRepository
    ) {
        this.empresaTerciariaService = empresaTerciariaService;
        this.empresaTerciariaRepository = empresaTerciariaRepository;
    }

    /**
     * {@code POST  /empresa-terciarias} : Create a new empresaTerciaria.
     *
     * @param empresaTerciariaDTO the empresaTerciariaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new empresaTerciariaDTO, or with status {@code 400 (Bad Request)} if the empresaTerciaria has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/empresa-terciarias")
    public ResponseEntity<EmpresaTerciariaDTO> createEmpresaTerciaria(@RequestBody EmpresaTerciariaDTO empresaTerciariaDTO)
        throws URISyntaxException {
        log.debug("REST request to save EmpresaTerciaria : {}", empresaTerciariaDTO);
        if (empresaTerciariaDTO.getId() != null) {
            throw new BadRequestAlertException("A new empresaTerciaria cannot already have an ID", ENTITY_NAME, "idexists");
        }
        EmpresaTerciariaDTO result = empresaTerciariaService.save(empresaTerciariaDTO);
        return ResponseEntity
            .created(new URI("/api/empresa-terciarias/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /empresa-terciarias/:id} : Updates an existing empresaTerciaria.
     *
     * @param id the id of the empresaTerciariaDTO to save.
     * @param empresaTerciariaDTO the empresaTerciariaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated empresaTerciariaDTO,
     * or with status {@code 400 (Bad Request)} if the empresaTerciariaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the empresaTerciariaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/empresa-terciarias/{id}")
    public ResponseEntity<EmpresaTerciariaDTO> updateEmpresaTerciaria(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody EmpresaTerciariaDTO empresaTerciariaDTO
    ) throws URISyntaxException {
        log.debug("REST request to update EmpresaTerciaria : {}, {}", id, empresaTerciariaDTO);
        if (empresaTerciariaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, empresaTerciariaDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!empresaTerciariaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        EmpresaTerciariaDTO result = empresaTerciariaService.save(empresaTerciariaDTO);
        return ResponseEntity
            .ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, empresaTerciariaDTO.getId().toString()))
            .body(result);
    }

    /**
     * {@code PATCH  /empresa-terciarias/:id} : Partial updates given fields of an existing empresaTerciaria, field will ignore if it is null
     *
     * @param id the id of the empresaTerciariaDTO to save.
     * @param empresaTerciariaDTO the empresaTerciariaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated empresaTerciariaDTO,
     * or with status {@code 400 (Bad Request)} if the empresaTerciariaDTO is not valid,
     * or with status {@code 404 (Not Found)} if the empresaTerciariaDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the empresaTerciariaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/empresa-terciarias/{id}", consumes = "application/merge-patch+json")
    public ResponseEntity<EmpresaTerciariaDTO> partialUpdateEmpresaTerciaria(
        @PathVariable(value = "id", required = false) final Long id,
        @RequestBody EmpresaTerciariaDTO empresaTerciariaDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update EmpresaTerciaria partially : {}, {}", id, empresaTerciariaDTO);
        if (empresaTerciariaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, empresaTerciariaDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!empresaTerciariaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<EmpresaTerciariaDTO> result = empresaTerciariaService.partialUpdate(empresaTerciariaDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, empresaTerciariaDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /empresa-terciarias} : get all the empresaTerciarias.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of empresaTerciarias in body.
     */
    @GetMapping("/empresa-terciarias")
    public List<EmpresaTerciariaDTO> getAllEmpresaTerciarias() {
        log.debug("REST request to get all EmpresaTerciarias");
        return empresaTerciariaService.findAll();
    }

    /**
     * {@code GET  /empresa-terciarias/:id} : get the "id" empresaTerciaria.
     *
     * @param id the id of the empresaTerciariaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the empresaTerciariaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/empresa-terciarias/{id}")
    public ResponseEntity<EmpresaTerciariaDTO> getEmpresaTerciaria(@PathVariable Long id) {
        log.debug("REST request to get EmpresaTerciaria : {}", id);
        Optional<EmpresaTerciariaDTO> empresaTerciariaDTO = empresaTerciariaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(empresaTerciariaDTO);
    }

    /**
     * {@code DELETE  /empresa-terciarias/:id} : delete the "id" empresaTerciaria.
     *
     * @param id the id of the empresaTerciariaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/empresa-terciarias/{id}")
    public ResponseEntity<Void> deleteEmpresaTerciaria(@PathVariable Long id) {
        log.debug("REST request to delete EmpresaTerciaria : {}", id);
        empresaTerciariaService.delete(id);
        return ResponseEntity
            .noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
