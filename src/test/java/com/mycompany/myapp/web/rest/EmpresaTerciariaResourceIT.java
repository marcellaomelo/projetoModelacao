package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.EmpresaTerciaria;
import com.mycompany.myapp.repository.EmpresaTerciariaRepository;
import com.mycompany.myapp.service.dto.EmpresaTerciariaDTO;
import com.mycompany.myapp.service.mapper.EmpresaTerciariaMapper;
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
 * Integration tests for the {@link EmpresaTerciariaResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class EmpresaTerciariaResourceIT {

    private static final String DEFAULT_INTERPRETE_EMPRESA_NAME = "AAAAAAAAAA";
    private static final String UPDATED_INTERPRETE_EMPRESA_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_INTERPRETE_EMPRESA_DATA_DISPONIVEL = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_INTERPRETE_EMPRESA_DATA_DISPONIVEL = LocalDate.now(ZoneId.systemDefault());

    private static final Boolean DEFAULT_PEDIDO_INTERPRETE_EMPRESA = false;
    private static final Boolean UPDATED_PEDIDO_INTERPRETE_EMPRESA = true;

    private static final String ENTITY_API_URL = "/api/empresa-terciarias";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private EmpresaTerciariaRepository empresaTerciariaRepository;

    @Autowired
    private EmpresaTerciariaMapper empresaTerciariaMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restEmpresaTerciariaMockMvc;

    private EmpresaTerciaria empresaTerciaria;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EmpresaTerciaria createEntity(EntityManager em) {
        EmpresaTerciaria empresaTerciaria = new EmpresaTerciaria()
            .interpreteEmpresaName(DEFAULT_INTERPRETE_EMPRESA_NAME)
            .interpreteEmpresaDataDisponivel(DEFAULT_INTERPRETE_EMPRESA_DATA_DISPONIVEL)
            .pedidoInterpreteEmpresa(DEFAULT_PEDIDO_INTERPRETE_EMPRESA);
        return empresaTerciaria;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static EmpresaTerciaria createUpdatedEntity(EntityManager em) {
        EmpresaTerciaria empresaTerciaria = new EmpresaTerciaria()
            .interpreteEmpresaName(UPDATED_INTERPRETE_EMPRESA_NAME)
            .interpreteEmpresaDataDisponivel(UPDATED_INTERPRETE_EMPRESA_DATA_DISPONIVEL)
            .pedidoInterpreteEmpresa(UPDATED_PEDIDO_INTERPRETE_EMPRESA);
        return empresaTerciaria;
    }

    @BeforeEach
    public void initTest() {
        empresaTerciaria = createEntity(em);
    }

    @Test
    @Transactional
    void createEmpresaTerciaria() throws Exception {
        int databaseSizeBeforeCreate = empresaTerciariaRepository.findAll().size();
        // Create the EmpresaTerciaria
        EmpresaTerciariaDTO empresaTerciariaDTO = empresaTerciariaMapper.toDto(empresaTerciaria);
        restEmpresaTerciariaMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(empresaTerciariaDTO))
            )
            .andExpect(status().isCreated());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeCreate + 1);
        EmpresaTerciaria testEmpresaTerciaria = empresaTerciariaList.get(empresaTerciariaList.size() - 1);
        assertThat(testEmpresaTerciaria.getInterpreteEmpresaName()).isEqualTo(DEFAULT_INTERPRETE_EMPRESA_NAME);
        assertThat(testEmpresaTerciaria.getInterpreteEmpresaDataDisponivel()).isEqualTo(DEFAULT_INTERPRETE_EMPRESA_DATA_DISPONIVEL);
        assertThat(testEmpresaTerciaria.getPedidoInterpreteEmpresa()).isEqualTo(DEFAULT_PEDIDO_INTERPRETE_EMPRESA);
    }

    @Test
    @Transactional
    void createEmpresaTerciariaWithExistingId() throws Exception {
        // Create the EmpresaTerciaria with an existing ID
        empresaTerciaria.setId(1L);
        EmpresaTerciariaDTO empresaTerciariaDTO = empresaTerciariaMapper.toDto(empresaTerciaria);

        int databaseSizeBeforeCreate = empresaTerciariaRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restEmpresaTerciariaMockMvc
            .perform(
                post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(empresaTerciariaDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllEmpresaTerciarias() throws Exception {
        // Initialize the database
        empresaTerciariaRepository.saveAndFlush(empresaTerciaria);

        // Get all the empresaTerciariaList
        restEmpresaTerciariaMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(empresaTerciaria.getId().intValue())))
            .andExpect(jsonPath("$.[*].interpreteEmpresaName").value(hasItem(DEFAULT_INTERPRETE_EMPRESA_NAME)))
            .andExpect(
                jsonPath("$.[*].interpreteEmpresaDataDisponivel").value(hasItem(DEFAULT_INTERPRETE_EMPRESA_DATA_DISPONIVEL.toString()))
            )
            .andExpect(jsonPath("$.[*].pedidoInterpreteEmpresa").value(hasItem(DEFAULT_PEDIDO_INTERPRETE_EMPRESA.booleanValue())));
    }

    @Test
    @Transactional
    void getEmpresaTerciaria() throws Exception {
        // Initialize the database
        empresaTerciariaRepository.saveAndFlush(empresaTerciaria);

        // Get the empresaTerciaria
        restEmpresaTerciariaMockMvc
            .perform(get(ENTITY_API_URL_ID, empresaTerciaria.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(empresaTerciaria.getId().intValue()))
            .andExpect(jsonPath("$.interpreteEmpresaName").value(DEFAULT_INTERPRETE_EMPRESA_NAME))
            .andExpect(jsonPath("$.interpreteEmpresaDataDisponivel").value(DEFAULT_INTERPRETE_EMPRESA_DATA_DISPONIVEL.toString()))
            .andExpect(jsonPath("$.pedidoInterpreteEmpresa").value(DEFAULT_PEDIDO_INTERPRETE_EMPRESA.booleanValue()));
    }

    @Test
    @Transactional
    void getNonExistingEmpresaTerciaria() throws Exception {
        // Get the empresaTerciaria
        restEmpresaTerciariaMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewEmpresaTerciaria() throws Exception {
        // Initialize the database
        empresaTerciariaRepository.saveAndFlush(empresaTerciaria);

        int databaseSizeBeforeUpdate = empresaTerciariaRepository.findAll().size();

        // Update the empresaTerciaria
        EmpresaTerciaria updatedEmpresaTerciaria = empresaTerciariaRepository.findById(empresaTerciaria.getId()).get();
        // Disconnect from session so that the updates on updatedEmpresaTerciaria are not directly saved in db
        em.detach(updatedEmpresaTerciaria);
        updatedEmpresaTerciaria
            .interpreteEmpresaName(UPDATED_INTERPRETE_EMPRESA_NAME)
            .interpreteEmpresaDataDisponivel(UPDATED_INTERPRETE_EMPRESA_DATA_DISPONIVEL)
            .pedidoInterpreteEmpresa(UPDATED_PEDIDO_INTERPRETE_EMPRESA);
        EmpresaTerciariaDTO empresaTerciariaDTO = empresaTerciariaMapper.toDto(updatedEmpresaTerciaria);

        restEmpresaTerciariaMockMvc
            .perform(
                put(ENTITY_API_URL_ID, empresaTerciariaDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(empresaTerciariaDTO))
            )
            .andExpect(status().isOk());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeUpdate);
        EmpresaTerciaria testEmpresaTerciaria = empresaTerciariaList.get(empresaTerciariaList.size() - 1);
        assertThat(testEmpresaTerciaria.getInterpreteEmpresaName()).isEqualTo(UPDATED_INTERPRETE_EMPRESA_NAME);
        assertThat(testEmpresaTerciaria.getInterpreteEmpresaDataDisponivel()).isEqualTo(UPDATED_INTERPRETE_EMPRESA_DATA_DISPONIVEL);
        assertThat(testEmpresaTerciaria.getPedidoInterpreteEmpresa()).isEqualTo(UPDATED_PEDIDO_INTERPRETE_EMPRESA);
    }

    @Test
    @Transactional
    void putNonExistingEmpresaTerciaria() throws Exception {
        int databaseSizeBeforeUpdate = empresaTerciariaRepository.findAll().size();
        empresaTerciaria.setId(count.incrementAndGet());

        // Create the EmpresaTerciaria
        EmpresaTerciariaDTO empresaTerciariaDTO = empresaTerciariaMapper.toDto(empresaTerciaria);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restEmpresaTerciariaMockMvc
            .perform(
                put(ENTITY_API_URL_ID, empresaTerciariaDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(empresaTerciariaDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchEmpresaTerciaria() throws Exception {
        int databaseSizeBeforeUpdate = empresaTerciariaRepository.findAll().size();
        empresaTerciaria.setId(count.incrementAndGet());

        // Create the EmpresaTerciaria
        EmpresaTerciariaDTO empresaTerciariaDTO = empresaTerciariaMapper.toDto(empresaTerciaria);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEmpresaTerciariaMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(empresaTerciariaDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamEmpresaTerciaria() throws Exception {
        int databaseSizeBeforeUpdate = empresaTerciariaRepository.findAll().size();
        empresaTerciaria.setId(count.incrementAndGet());

        // Create the EmpresaTerciaria
        EmpresaTerciariaDTO empresaTerciariaDTO = empresaTerciariaMapper.toDto(empresaTerciaria);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEmpresaTerciariaMockMvc
            .perform(
                put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(empresaTerciariaDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateEmpresaTerciariaWithPatch() throws Exception {
        // Initialize the database
        empresaTerciariaRepository.saveAndFlush(empresaTerciaria);

        int databaseSizeBeforeUpdate = empresaTerciariaRepository.findAll().size();

        // Update the empresaTerciaria using partial update
        EmpresaTerciaria partialUpdatedEmpresaTerciaria = new EmpresaTerciaria();
        partialUpdatedEmpresaTerciaria.setId(empresaTerciaria.getId());

        partialUpdatedEmpresaTerciaria.pedidoInterpreteEmpresa(UPDATED_PEDIDO_INTERPRETE_EMPRESA);

        restEmpresaTerciariaMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedEmpresaTerciaria.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedEmpresaTerciaria))
            )
            .andExpect(status().isOk());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeUpdate);
        EmpresaTerciaria testEmpresaTerciaria = empresaTerciariaList.get(empresaTerciariaList.size() - 1);
        assertThat(testEmpresaTerciaria.getInterpreteEmpresaName()).isEqualTo(DEFAULT_INTERPRETE_EMPRESA_NAME);
        assertThat(testEmpresaTerciaria.getInterpreteEmpresaDataDisponivel()).isEqualTo(DEFAULT_INTERPRETE_EMPRESA_DATA_DISPONIVEL);
        assertThat(testEmpresaTerciaria.getPedidoInterpreteEmpresa()).isEqualTo(UPDATED_PEDIDO_INTERPRETE_EMPRESA);
    }

    @Test
    @Transactional
    void fullUpdateEmpresaTerciariaWithPatch() throws Exception {
        // Initialize the database
        empresaTerciariaRepository.saveAndFlush(empresaTerciaria);

        int databaseSizeBeforeUpdate = empresaTerciariaRepository.findAll().size();

        // Update the empresaTerciaria using partial update
        EmpresaTerciaria partialUpdatedEmpresaTerciaria = new EmpresaTerciaria();
        partialUpdatedEmpresaTerciaria.setId(empresaTerciaria.getId());

        partialUpdatedEmpresaTerciaria
            .interpreteEmpresaName(UPDATED_INTERPRETE_EMPRESA_NAME)
            .interpreteEmpresaDataDisponivel(UPDATED_INTERPRETE_EMPRESA_DATA_DISPONIVEL)
            .pedidoInterpreteEmpresa(UPDATED_PEDIDO_INTERPRETE_EMPRESA);

        restEmpresaTerciariaMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedEmpresaTerciaria.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedEmpresaTerciaria))
            )
            .andExpect(status().isOk());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeUpdate);
        EmpresaTerciaria testEmpresaTerciaria = empresaTerciariaList.get(empresaTerciariaList.size() - 1);
        assertThat(testEmpresaTerciaria.getInterpreteEmpresaName()).isEqualTo(UPDATED_INTERPRETE_EMPRESA_NAME);
        assertThat(testEmpresaTerciaria.getInterpreteEmpresaDataDisponivel()).isEqualTo(UPDATED_INTERPRETE_EMPRESA_DATA_DISPONIVEL);
        assertThat(testEmpresaTerciaria.getPedidoInterpreteEmpresa()).isEqualTo(UPDATED_PEDIDO_INTERPRETE_EMPRESA);
    }

    @Test
    @Transactional
    void patchNonExistingEmpresaTerciaria() throws Exception {
        int databaseSizeBeforeUpdate = empresaTerciariaRepository.findAll().size();
        empresaTerciaria.setId(count.incrementAndGet());

        // Create the EmpresaTerciaria
        EmpresaTerciariaDTO empresaTerciariaDTO = empresaTerciariaMapper.toDto(empresaTerciaria);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restEmpresaTerciariaMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, empresaTerciariaDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(empresaTerciariaDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchEmpresaTerciaria() throws Exception {
        int databaseSizeBeforeUpdate = empresaTerciariaRepository.findAll().size();
        empresaTerciaria.setId(count.incrementAndGet());

        // Create the EmpresaTerciaria
        EmpresaTerciariaDTO empresaTerciariaDTO = empresaTerciariaMapper.toDto(empresaTerciaria);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEmpresaTerciariaMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(empresaTerciariaDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamEmpresaTerciaria() throws Exception {
        int databaseSizeBeforeUpdate = empresaTerciariaRepository.findAll().size();
        empresaTerciaria.setId(count.incrementAndGet());

        // Create the EmpresaTerciaria
        EmpresaTerciariaDTO empresaTerciariaDTO = empresaTerciariaMapper.toDto(empresaTerciaria);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restEmpresaTerciariaMockMvc
            .perform(
                patch(ENTITY_API_URL)
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(empresaTerciariaDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the EmpresaTerciaria in the database
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteEmpresaTerciaria() throws Exception {
        // Initialize the database
        empresaTerciariaRepository.saveAndFlush(empresaTerciaria);

        int databaseSizeBeforeDelete = empresaTerciariaRepository.findAll().size();

        // Delete the empresaTerciaria
        restEmpresaTerciariaMockMvc
            .perform(delete(ENTITY_API_URL_ID, empresaTerciaria.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<EmpresaTerciaria> empresaTerciariaList = empresaTerciariaRepository.findAll();
        assertThat(empresaTerciariaList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
