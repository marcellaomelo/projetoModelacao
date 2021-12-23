package com.mycompany.myapp.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.mycompany.myapp.IntegrationTest;
import com.mycompany.myapp.domain.Freelancer;
import com.mycompany.myapp.repository.FreelancerRepository;
import com.mycompany.myapp.service.dto.FreelancerDTO;
import com.mycompany.myapp.service.mapper.FreelancerMapper;
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
 * Integration tests for the {@link FreelancerResource} REST controller.
 */
@IntegrationTest
@AutoConfigureMockMvc
@WithMockUser
class FreelancerResourceIT {

    private static final String DEFAULT_FREELANCER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FREELANCER_NAME = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_FREELANCER_DATA_DISPONIVEL = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_FREELANCER_DATA_DISPONIVEL = LocalDate.now(ZoneId.systemDefault());

    private static final Boolean DEFAULT_EXISTE_FREELANCER_DISPONIVEL = false;
    private static final Boolean UPDATED_EXISTE_FREELANCER_DISPONIVEL = true;

    private static final Boolean DEFAULT_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL = false;
    private static final Boolean UPDATED_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL = true;

    private static final Integer DEFAULT_ANOS_EXPERIENCIA_FREELANCER = 1;
    private static final Integer UPDATED_ANOS_EXPERIENCIA_FREELANCER = 2;

    private static final String DEFAULT_FREELANCER_ESCOLHIDO = "AAAAAAAAAA";
    private static final String UPDATED_FREELANCER_ESCOLHIDO = "BBBBBBBBBB";

    private static final String DEFAULT_FREELANCER_UNICO_ESCOLHIDO = "AAAAAAAAAA";
    private static final String UPDATED_FREELANCER_UNICO_ESCOLHIDO = "BBBBBBBBBB";

    private static final String ENTITY_API_URL = "/api/freelancers";
    private static final String ENTITY_API_URL_ID = ENTITY_API_URL + "/{id}";

    private static Random random = new Random();
    private static AtomicLong count = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private FreelancerMapper freelancerMapper;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restFreelancerMockMvc;

    private Freelancer freelancer;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Freelancer createEntity(EntityManager em) {
        Freelancer freelancer = new Freelancer()
            .freelancerName(DEFAULT_FREELANCER_NAME)
            .freelancerDataDisponivel(DEFAULT_FREELANCER_DATA_DISPONIVEL)
            .existeFreelancerDisponivel(DEFAULT_EXISTE_FREELANCER_DISPONIVEL)
            .existeMaisQueUmFreelancerDisponivel(DEFAULT_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL)
            .anosExperienciaFreelancer(DEFAULT_ANOS_EXPERIENCIA_FREELANCER)
            .freelancerEscolhido(DEFAULT_FREELANCER_ESCOLHIDO)
            .freelancerUnicoEscolhido(DEFAULT_FREELANCER_UNICO_ESCOLHIDO);
        return freelancer;
    }

    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Freelancer createUpdatedEntity(EntityManager em) {
        Freelancer freelancer = new Freelancer()
            .freelancerName(UPDATED_FREELANCER_NAME)
            .freelancerDataDisponivel(UPDATED_FREELANCER_DATA_DISPONIVEL)
            .existeFreelancerDisponivel(UPDATED_EXISTE_FREELANCER_DISPONIVEL)
            .existeMaisQueUmFreelancerDisponivel(UPDATED_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL)
            .anosExperienciaFreelancer(UPDATED_ANOS_EXPERIENCIA_FREELANCER)
            .freelancerEscolhido(UPDATED_FREELANCER_ESCOLHIDO)
            .freelancerUnicoEscolhido(UPDATED_FREELANCER_UNICO_ESCOLHIDO);
        return freelancer;
    }

    @BeforeEach
    public void initTest() {
        freelancer = createEntity(em);
    }

    @Test
    @Transactional
    void createFreelancer() throws Exception {
        int databaseSizeBeforeCreate = freelancerRepository.findAll().size();
        // Create the Freelancer
        FreelancerDTO freelancerDTO = freelancerMapper.toDto(freelancer);
        restFreelancerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(freelancerDTO)))
            .andExpect(status().isCreated());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeCreate + 1);
        Freelancer testFreelancer = freelancerList.get(freelancerList.size() - 1);
        assertThat(testFreelancer.getFreelancerName()).isEqualTo(DEFAULT_FREELANCER_NAME);
        assertThat(testFreelancer.getFreelancerDataDisponivel()).isEqualTo(DEFAULT_FREELANCER_DATA_DISPONIVEL);
        assertThat(testFreelancer.getExisteFreelancerDisponivel()).isEqualTo(DEFAULT_EXISTE_FREELANCER_DISPONIVEL);
        assertThat(testFreelancer.getExisteMaisQueUmFreelancerDisponivel()).isEqualTo(DEFAULT_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL);
        assertThat(testFreelancer.getAnosExperienciaFreelancer()).isEqualTo(DEFAULT_ANOS_EXPERIENCIA_FREELANCER);
        assertThat(testFreelancer.getFreelancerEscolhido()).isEqualTo(DEFAULT_FREELANCER_ESCOLHIDO);
        assertThat(testFreelancer.getFreelancerUnicoEscolhido()).isEqualTo(DEFAULT_FREELANCER_UNICO_ESCOLHIDO);
    }

    @Test
    @Transactional
    void createFreelancerWithExistingId() throws Exception {
        // Create the Freelancer with an existing ID
        freelancer.setId(1L);
        FreelancerDTO freelancerDTO = freelancerMapper.toDto(freelancer);

        int databaseSizeBeforeCreate = freelancerRepository.findAll().size();

        // An entity with an existing ID cannot be created, so this API call must fail
        restFreelancerMockMvc
            .perform(post(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(freelancerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    void getAllFreelancers() throws Exception {
        // Initialize the database
        freelancerRepository.saveAndFlush(freelancer);

        // Get all the freelancerList
        restFreelancerMockMvc
            .perform(get(ENTITY_API_URL + "?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(freelancer.getId().intValue())))
            .andExpect(jsonPath("$.[*].freelancerName").value(hasItem(DEFAULT_FREELANCER_NAME)))
            .andExpect(jsonPath("$.[*].freelancerDataDisponivel").value(hasItem(DEFAULT_FREELANCER_DATA_DISPONIVEL.toString())))
            .andExpect(jsonPath("$.[*].existeFreelancerDisponivel").value(hasItem(DEFAULT_EXISTE_FREELANCER_DISPONIVEL.booleanValue())))
            .andExpect(
                jsonPath("$.[*].existeMaisQueUmFreelancerDisponivel")
                    .value(hasItem(DEFAULT_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL.booleanValue()))
            )
            .andExpect(jsonPath("$.[*].anosExperienciaFreelancer").value(hasItem(DEFAULT_ANOS_EXPERIENCIA_FREELANCER)))
            .andExpect(jsonPath("$.[*].freelancerEscolhido").value(hasItem(DEFAULT_FREELANCER_ESCOLHIDO)))
            .andExpect(jsonPath("$.[*].freelancerUnicoEscolhido").value(hasItem(DEFAULT_FREELANCER_UNICO_ESCOLHIDO)));
    }

    @Test
    @Transactional
    void getFreelancer() throws Exception {
        // Initialize the database
        freelancerRepository.saveAndFlush(freelancer);

        // Get the freelancer
        restFreelancerMockMvc
            .perform(get(ENTITY_API_URL_ID, freelancer.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(freelancer.getId().intValue()))
            .andExpect(jsonPath("$.freelancerName").value(DEFAULT_FREELANCER_NAME))
            .andExpect(jsonPath("$.freelancerDataDisponivel").value(DEFAULT_FREELANCER_DATA_DISPONIVEL.toString()))
            .andExpect(jsonPath("$.existeFreelancerDisponivel").value(DEFAULT_EXISTE_FREELANCER_DISPONIVEL.booleanValue()))
            .andExpect(
                jsonPath("$.existeMaisQueUmFreelancerDisponivel").value(DEFAULT_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL.booleanValue())
            )
            .andExpect(jsonPath("$.anosExperienciaFreelancer").value(DEFAULT_ANOS_EXPERIENCIA_FREELANCER))
            .andExpect(jsonPath("$.freelancerEscolhido").value(DEFAULT_FREELANCER_ESCOLHIDO))
            .andExpect(jsonPath("$.freelancerUnicoEscolhido").value(DEFAULT_FREELANCER_UNICO_ESCOLHIDO));
    }

    @Test
    @Transactional
    void getNonExistingFreelancer() throws Exception {
        // Get the freelancer
        restFreelancerMockMvc.perform(get(ENTITY_API_URL_ID, Long.MAX_VALUE)).andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    void putNewFreelancer() throws Exception {
        // Initialize the database
        freelancerRepository.saveAndFlush(freelancer);

        int databaseSizeBeforeUpdate = freelancerRepository.findAll().size();

        // Update the freelancer
        Freelancer updatedFreelancer = freelancerRepository.findById(freelancer.getId()).get();
        // Disconnect from session so that the updates on updatedFreelancer are not directly saved in db
        em.detach(updatedFreelancer);
        updatedFreelancer
            .freelancerName(UPDATED_FREELANCER_NAME)
            .freelancerDataDisponivel(UPDATED_FREELANCER_DATA_DISPONIVEL)
            .existeFreelancerDisponivel(UPDATED_EXISTE_FREELANCER_DISPONIVEL)
            .existeMaisQueUmFreelancerDisponivel(UPDATED_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL)
            .anosExperienciaFreelancer(UPDATED_ANOS_EXPERIENCIA_FREELANCER)
            .freelancerEscolhido(UPDATED_FREELANCER_ESCOLHIDO)
            .freelancerUnicoEscolhido(UPDATED_FREELANCER_UNICO_ESCOLHIDO);
        FreelancerDTO freelancerDTO = freelancerMapper.toDto(updatedFreelancer);

        restFreelancerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, freelancerDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(freelancerDTO))
            )
            .andExpect(status().isOk());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeUpdate);
        Freelancer testFreelancer = freelancerList.get(freelancerList.size() - 1);
        assertThat(testFreelancer.getFreelancerName()).isEqualTo(UPDATED_FREELANCER_NAME);
        assertThat(testFreelancer.getFreelancerDataDisponivel()).isEqualTo(UPDATED_FREELANCER_DATA_DISPONIVEL);
        assertThat(testFreelancer.getExisteFreelancerDisponivel()).isEqualTo(UPDATED_EXISTE_FREELANCER_DISPONIVEL);
        assertThat(testFreelancer.getExisteMaisQueUmFreelancerDisponivel()).isEqualTo(UPDATED_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL);
        assertThat(testFreelancer.getAnosExperienciaFreelancer()).isEqualTo(UPDATED_ANOS_EXPERIENCIA_FREELANCER);
        assertThat(testFreelancer.getFreelancerEscolhido()).isEqualTo(UPDATED_FREELANCER_ESCOLHIDO);
        assertThat(testFreelancer.getFreelancerUnicoEscolhido()).isEqualTo(UPDATED_FREELANCER_UNICO_ESCOLHIDO);
    }

    @Test
    @Transactional
    void putNonExistingFreelancer() throws Exception {
        int databaseSizeBeforeUpdate = freelancerRepository.findAll().size();
        freelancer.setId(count.incrementAndGet());

        // Create the Freelancer
        FreelancerDTO freelancerDTO = freelancerMapper.toDto(freelancer);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFreelancerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, freelancerDTO.getId())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(freelancerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithIdMismatchFreelancer() throws Exception {
        int databaseSizeBeforeUpdate = freelancerRepository.findAll().size();
        freelancer.setId(count.incrementAndGet());

        // Create the Freelancer
        FreelancerDTO freelancerDTO = freelancerMapper.toDto(freelancer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFreelancerMockMvc
            .perform(
                put(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(TestUtil.convertObjectToJsonBytes(freelancerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void putWithMissingIdPathParamFreelancer() throws Exception {
        int databaseSizeBeforeUpdate = freelancerRepository.findAll().size();
        freelancer.setId(count.incrementAndGet());

        // Create the Freelancer
        FreelancerDTO freelancerDTO = freelancerMapper.toDto(freelancer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFreelancerMockMvc
            .perform(put(ENTITY_API_URL).contentType(MediaType.APPLICATION_JSON).content(TestUtil.convertObjectToJsonBytes(freelancerDTO)))
            .andExpect(status().isMethodNotAllowed());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void partialUpdateFreelancerWithPatch() throws Exception {
        // Initialize the database
        freelancerRepository.saveAndFlush(freelancer);

        int databaseSizeBeforeUpdate = freelancerRepository.findAll().size();

        // Update the freelancer using partial update
        Freelancer partialUpdatedFreelancer = new Freelancer();
        partialUpdatedFreelancer.setId(freelancer.getId());

        partialUpdatedFreelancer
            .existeFreelancerDisponivel(UPDATED_EXISTE_FREELANCER_DISPONIVEL)
            .freelancerEscolhido(UPDATED_FREELANCER_ESCOLHIDO)
            .freelancerUnicoEscolhido(UPDATED_FREELANCER_UNICO_ESCOLHIDO);

        restFreelancerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFreelancer.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedFreelancer))
            )
            .andExpect(status().isOk());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeUpdate);
        Freelancer testFreelancer = freelancerList.get(freelancerList.size() - 1);
        assertThat(testFreelancer.getFreelancerName()).isEqualTo(DEFAULT_FREELANCER_NAME);
        assertThat(testFreelancer.getFreelancerDataDisponivel()).isEqualTo(DEFAULT_FREELANCER_DATA_DISPONIVEL);
        assertThat(testFreelancer.getExisteFreelancerDisponivel()).isEqualTo(UPDATED_EXISTE_FREELANCER_DISPONIVEL);
        assertThat(testFreelancer.getExisteMaisQueUmFreelancerDisponivel()).isEqualTo(DEFAULT_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL);
        assertThat(testFreelancer.getAnosExperienciaFreelancer()).isEqualTo(DEFAULT_ANOS_EXPERIENCIA_FREELANCER);
        assertThat(testFreelancer.getFreelancerEscolhido()).isEqualTo(UPDATED_FREELANCER_ESCOLHIDO);
        assertThat(testFreelancer.getFreelancerUnicoEscolhido()).isEqualTo(UPDATED_FREELANCER_UNICO_ESCOLHIDO);
    }

    @Test
    @Transactional
    void fullUpdateFreelancerWithPatch() throws Exception {
        // Initialize the database
        freelancerRepository.saveAndFlush(freelancer);

        int databaseSizeBeforeUpdate = freelancerRepository.findAll().size();

        // Update the freelancer using partial update
        Freelancer partialUpdatedFreelancer = new Freelancer();
        partialUpdatedFreelancer.setId(freelancer.getId());

        partialUpdatedFreelancer
            .freelancerName(UPDATED_FREELANCER_NAME)
            .freelancerDataDisponivel(UPDATED_FREELANCER_DATA_DISPONIVEL)
            .existeFreelancerDisponivel(UPDATED_EXISTE_FREELANCER_DISPONIVEL)
            .existeMaisQueUmFreelancerDisponivel(UPDATED_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL)
            .anosExperienciaFreelancer(UPDATED_ANOS_EXPERIENCIA_FREELANCER)
            .freelancerEscolhido(UPDATED_FREELANCER_ESCOLHIDO)
            .freelancerUnicoEscolhido(UPDATED_FREELANCER_UNICO_ESCOLHIDO);

        restFreelancerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, partialUpdatedFreelancer.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(partialUpdatedFreelancer))
            )
            .andExpect(status().isOk());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeUpdate);
        Freelancer testFreelancer = freelancerList.get(freelancerList.size() - 1);
        assertThat(testFreelancer.getFreelancerName()).isEqualTo(UPDATED_FREELANCER_NAME);
        assertThat(testFreelancer.getFreelancerDataDisponivel()).isEqualTo(UPDATED_FREELANCER_DATA_DISPONIVEL);
        assertThat(testFreelancer.getExisteFreelancerDisponivel()).isEqualTo(UPDATED_EXISTE_FREELANCER_DISPONIVEL);
        assertThat(testFreelancer.getExisteMaisQueUmFreelancerDisponivel()).isEqualTo(UPDATED_EXISTE_MAIS_QUE_UM_FREELANCER_DISPONIVEL);
        assertThat(testFreelancer.getAnosExperienciaFreelancer()).isEqualTo(UPDATED_ANOS_EXPERIENCIA_FREELANCER);
        assertThat(testFreelancer.getFreelancerEscolhido()).isEqualTo(UPDATED_FREELANCER_ESCOLHIDO);
        assertThat(testFreelancer.getFreelancerUnicoEscolhido()).isEqualTo(UPDATED_FREELANCER_UNICO_ESCOLHIDO);
    }

    @Test
    @Transactional
    void patchNonExistingFreelancer() throws Exception {
        int databaseSizeBeforeUpdate = freelancerRepository.findAll().size();
        freelancer.setId(count.incrementAndGet());

        // Create the Freelancer
        FreelancerDTO freelancerDTO = freelancerMapper.toDto(freelancer);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restFreelancerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, freelancerDTO.getId())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(freelancerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithIdMismatchFreelancer() throws Exception {
        int databaseSizeBeforeUpdate = freelancerRepository.findAll().size();
        freelancer.setId(count.incrementAndGet());

        // Create the Freelancer
        FreelancerDTO freelancerDTO = freelancerMapper.toDto(freelancer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFreelancerMockMvc
            .perform(
                patch(ENTITY_API_URL_ID, count.incrementAndGet())
                    .contentType("application/merge-patch+json")
                    .content(TestUtil.convertObjectToJsonBytes(freelancerDTO))
            )
            .andExpect(status().isBadRequest());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void patchWithMissingIdPathParamFreelancer() throws Exception {
        int databaseSizeBeforeUpdate = freelancerRepository.findAll().size();
        freelancer.setId(count.incrementAndGet());

        // Create the Freelancer
        FreelancerDTO freelancerDTO = freelancerMapper.toDto(freelancer);

        // If url ID doesn't match entity ID, it will throw BadRequestAlertException
        restFreelancerMockMvc
            .perform(
                patch(ENTITY_API_URL).contentType("application/merge-patch+json").content(TestUtil.convertObjectToJsonBytes(freelancerDTO))
            )
            .andExpect(status().isMethodNotAllowed());

        // Validate the Freelancer in the database
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    void deleteFreelancer() throws Exception {
        // Initialize the database
        freelancerRepository.saveAndFlush(freelancer);

        int databaseSizeBeforeDelete = freelancerRepository.findAll().size();

        // Delete the freelancer
        restFreelancerMockMvc
            .perform(delete(ENTITY_API_URL_ID, freelancer.getId()).accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Freelancer> freelancerList = freelancerRepository.findAll();
        assertThat(freelancerList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
