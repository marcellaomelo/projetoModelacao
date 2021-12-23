package com.mycompany.myapp.web.rest;

import com.mycompany.myapp.repository.PedidoInterpreteRepository;
import com.mycompany.myapp.service.PedidoInterpreteService;
import com.mycompany.myapp.service.dto.PedidoInterpreteDTO;
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
 * REST controller for managing {@link com.mycompany.myapp.domain.PedidoInterprete}.
 */
@RestController
@RequestMapping("/api")
public class PedidoInterpreteResource {

    private final Logger log = LoggerFactory.getLogger(PedidoInterpreteResource.class);

    private final PedidoInterpreteService pedidoInterpreteService;

    private final PedidoInterpreteRepository pedidoInterpreteRepository;

    public PedidoInterpreteResource(
        PedidoInterpreteService pedidoInterpreteService,
        PedidoInterpreteRepository pedidoInterpreteRepository
    ) {
        this.pedidoInterpreteService = pedidoInterpreteService;
        this.pedidoInterpreteRepository = pedidoInterpreteRepository;
    }

    /**
     * {@code GET  /pedido-interpretes} : get all the pedidoInterpretes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pedidoInterpretes in body.
     */
    @GetMapping("/pedido-interpretes")
    public List<PedidoInterpreteDTO> getAllPedidoInterpretes() {
        log.debug("REST request to get all PedidoInterpretes");
        return pedidoInterpreteService.findAll();
    }

    /**
     * {@code GET  /pedido-interpretes/:id} : get the "id" pedidoInterprete.
     *
     * @param id the id of the pedidoInterpreteDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pedidoInterpreteDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/pedido-interpretes/{id}")
    public ResponseEntity<PedidoInterpreteDTO> getPedidoInterprete(@PathVariable Long id) {
        log.debug("REST request to get PedidoInterprete : {}", id);
        Optional<PedidoInterpreteDTO> pedidoInterpreteDTO = pedidoInterpreteService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pedidoInterpreteDTO);
    }
}
