package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.PedidoInterprete;
import com.mycompany.myapp.repository.PedidoInterpreteRepository;
import com.mycompany.myapp.service.dto.PedidoInterpreteDTO;
import com.mycompany.myapp.service.mapper.PedidoInterpreteMapper;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Integration tests for the {@link PedidoInterpreteResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class PedidoInterpreteResourceIT {

    private static final LocalDate DEFAULT_DATA_PEDIDO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATA_PEDIDO = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_LOCAL_TURISTICO_PEDIDO = "AAAAAAAAAA";
    private static final String UPDATED_LOCAL_TURISTICO_PEDIDO = "BBBBBBBBBB";

    private static final String DEFAULT_CLIENTE_NAME = "AAAAAAAAAA";
    private static final String UPDATED_CLIENTE_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_CLIENTE_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_CLIENTE_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_FREELANCER_NUMERO_RESERVA = "AAAAAAAAAA";
    private static final String UPDATED_FREELANCER_NUMERO_RESERVA = "BBBBBBBBBB";

    private static final String DEFAULT_EMPRESA_TERCIARIA_NUMERO_RESERVA = "AAAAAAAAAA";
    private static final String UPDATED_EMPRESA_TERCIARIA_NUMERO_RESERVA = "BBBBBBBBBB";

    private static final Integer DEFAULT_PRECO_RESERVA = 1;
    private static final Integer UPDATED_PRECO_RESERVA = 2;

    private static final Boolean DEFAULT_RESERVAR_SERVICO = false;
    private static final Boolean UPDATED_RESERVAR_SERVICO = true;

    private static final Boolean DEFAULT_CONFIRMACAO_RESERVA = false;
    private static final Boolean UPDATED_CONFIRMACAO_RESERVA = true;

    private static final String ENTITY_API_URL = "/api/pedido-interpretes";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private PedidoInterpreteRepository pedidoInterpreteRepository;

    @Autowired
    private PedidoInterpreteMapper pedidoInterpreteMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restPedidoInterpreteMockMvc;

    private PedidoInterprete pedidoInterprete;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PedidoInterprete createEntity(EntityManager em) {
        PedidoInterprete pedidoInterprete = new PedidoInterprete()
            .dataPedido(DEFAULT_DATA_PEDIDO)
            .localTuristicoPedido(DEFAULT_LOCAL_TURISTICO_PEDIDO)
            .clienteName(DEFAULT_CLIENTE_NAME)
            .clienteEmail(DEFAULT_CLIENTE_EMAIL)
            .freelancerNumeroReserva(DEFAULT_FREELANCER_NUMERO_RESERVA)
            .empresaTerciariaNumeroReserva(DEFAULT_EMPRESA_TERCIARIA_NUMERO_RESERVA)
            .precoReserva(DEFAULT_PRECO_RESERVA)
            .reservarServico(DEFAULT_RESERVAR_SERVICO)
            .confirmacaoReserva(DEFAULT_CONFIRMACAO_RESERVA);
        return pedidoInterprete;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PedidoInterprete createUpdatedEntity(EntityManager em) {
        PedidoInterprete pedidoInterprete = new PedidoInterprete()
            .dataPedido(UPDATED_DATA_PEDIDO)
            .localTuristicoPedido(UPDATED_LOCAL_TURISTICO_PEDIDO)
            .clienteName(UPDATED_CLIENTE_NAME)
            .clienteEmail(UPDATED_CLIENTE_EMAIL)
            .freelancerNumeroReserva(UPDATED_FREELANCER_NUMERO_RESERVA)
            .empresaTerciariaNumeroReserva(UPDATED_EMPRESA_TERCIARIA_NUMERO_RESERVA)
            .precoReserva(UPDATED_PRECO_RESERVA)
            .reservarServico(UPDATED_RESERVAR_SERVICO)
            .confirmacaoReserva(UPDATED_CONFIRMACAO_RESERVA);
        return pedidoInterprete;
    }

    @BeforeEach
    public void initTest() {
        pedidoInterprete = createEntity(em);
    }

    @Test
    @Transactional
    void getAllPedidoInterpretes() throws Exception {
        // Initialize the database
        pedidoInterpreteRepository.saveAndFlush(pedidoInterprete);

        // Get all the pedidoInterpreteList
        restPedidoInterpreteMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(pedidoInterprete.getId().intValue())))
            .andExpect(jsonPath("$.[*].dataPedido").value(hasItem(DEFAULT_DATA_PEDIDO.toString())))
            .andExpect(jsonPath("$.[*].localTuristicoPedido").value(hasItem(DEFAULT_LOCAL_TURISTICO_PEDIDO)))
            .andExpect(jsonPath("$.[*].clienteName").value(hasItem(DEFAULT_CLIENTE_NAME)))
            .andExpect(jsonPath("$.[*].clienteEmail").value(hasItem(DEFAULT_CLIENTE_EMAIL)))
            .andExpect(jsonPath("$.[*].freelancerNumeroReserva").value(hasItem(DEFAULT_FREELANCER_NUMERO_RESERVA)))
            .andExpect(jsonPath("$.[*].empresaTerciariaNumeroReserva").value(hasItem(DEFAULT_EMPRESA_TERCIARIA_NUMERO_RESERVA)))
            .andExpect(jsonPath("$.[*].precoReserva").value(hasItem(DEFAULT_PRECO_RESERVA)))
            .andExpect(jsonPath("$.[*].reservarServico").value(hasItem(DEFAULT_RESERVAR_SERVICO.booleanValue())))
            .andExpect(jsonPath("$.[*].confirmacaoReserva").value(hasItem(DEFAULT_CONFIRMACAO_RESERVA.booleanValue())));
    }

    @Test
    @Transactional
    void getPedidoInterprete() throws Exception {
        // Initialize the database
        pedidoInterpreteRepository.saveAndFlush(pedidoInterprete);

        // Get the pedidoInterprete
        restPedidoInterpreteMockMvc
            .perform(get(ENTITY_API_URL_ID, pedidoInterprete.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(pedidoInterprete.getId().intValue()))
            .andExpect(jsonPath("$.dataPedido").value(DEFAULT_DATA_PEDIDO.toString()))
            .andExpect(jsonPath("$.localTuristicoPedido").value(DEFAULT_LOCAL_TURISTICO_PEDIDO))
            .andExpect(jsonPath("$.clienteName").value(DEFAULT_CLIENTE_NAME))
            .andExpect(jsonPath("$.clienteEmail").value(DEFAULT_CLIENTE_EMAIL))
            .andExpect(jsonPath("$.freelancerNumeroReserva").value(DEFAULT_FREELANCER_NUMERO_RESERVA))
            .andExpect(jsonPath("$.empresaTerciariaNumeroReserva").value(DEFAULT_EMPRESA_TERCIARIA_NUMERO_RESERVA))
            .andExpect(jsonPath("$.precoReserva").value(DEFAULT_PRECO_RESERVA))
            .andExpect(jsonPath("$.reservarServico").value(DEFAULT_RESERVAR_SERVICO.booleanValue()))
            .andExpect(jsonPath("$.confirmacaoReserva").value(DEFAULT_CONFIRMACAO_RESERVA.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingPedidoInterprete() throws Exception {
        // Get the pedidoInterprete
        restPedidoInterpreteMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }
}
