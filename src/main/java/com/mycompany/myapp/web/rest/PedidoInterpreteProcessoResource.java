package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.service.PedidoInterpreteProcessoService;
import com.mycompany.myapp.service.dto.PedidoInterpreteProcessoDTO;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link com.mycompany.myapp.domain.PedidoInterpreteProcesso}.
 */
@RestController
@RequestMapping("/api")
public class PedidoInterpreteProcessoResource {

    private final Logger log = LoggerFactory.getLogger(PedidoInterpreteProcessoResource.class);

    private static final String ENTITY_NAME = "pedidoInterpreteProcesso";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PedidoInterpreteProcessoService pedidoInterpreteProcessoService;

    public PedidoInterpreteProcessoResource(PedidoInterpreteProcessoService pedidoInterpreteProcessoService) {
        this.pedidoInterpreteProcessoService = pedidoInterpreteProcessoService;
    }

    /**
     * {@code POST  /pedido-interprete-processos} : Create a new pedidoInterpreteProcesso.
     *
     * @param pedidoInterpreteProcessoDTO the pedidoInterpreteProcessoDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pedidoInterpreteProcessoDTO, or with status {@code 400 (Bad Request)} if the pedidoInterpreteProcesso has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/pedido-interprete-processos")
    public ResponseEntity<PedidoInterpreteProcessoDTO> create(@RequestBody PedidoInterpreteProcessoDTO pedidoInterpreteProcessoDTO)
        throws URISyntaxException {
        log.debug("REST request to save PedidoInterpreteProcesso : {}", pedidoInterpreteProcessoDTO);
        if (pedidoInterpreteProcessoDTO.getId() != null) {
            throw new BadRequestAlertException("A new pedidoInterpreteProcesso cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PedidoInterpreteProcessoDTO result = pedidoInterpreteProcessoService.create(pedidoInterpreteProcessoDTO);
        return ResponseEntity
            .created(new URI("/api/pedido-interprete-processos/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /pedido-interprete-processos} : get all the pedidoInterpreteProcessos.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pedidoInterpreteProcessos in body.
     */
    @GetMapping("/pedido-interprete-processos")
    public List<PedidoInterpreteProcessoDTO> getAllPedidoInterpreteProcessos() {
        log.debug("REST request to get all PedidoInterpreteProcessos");
        return pedidoInterpreteProcessoService.findAll();
    }

    /**
     * {@code GET  /pedido-interprete-processos/:id} : get the "id" pedidoInterpreteProcesso.
     *
     * @param processInstanceId the id of the pedidoInterpreteProcessoDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pedidoInterpreteProcessoDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pedido-interprete-processos/{processInstanceId}")
    public ResponseEntity<PedidoInterpreteProcessoDTO> getByProcessInstanceId(@PathVariable Long processInstanceId) {
        log.debug("REST request to get PedidoInterpreteProcesso by processInstanceId : {}", processInstanceId);
        Optional<PedidoInterpreteProcessoDTO> pedidoInterpreteProcessoDTO = pedidoInterpreteProcessoService.findByProcessInstanceId(
            processInstanceId
        );
        return ResponseUtil.wrapOrNotFound(pedidoInterpreteProcessoDTO);
    }
}
