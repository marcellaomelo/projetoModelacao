package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class FreelancerDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(FreelancerDTO.class);
        FreelancerDTO freelancerDTO1 = new FreelancerDTO();
        freelancerDTO1.setId(1L);
        FreelancerDTO freelancerDTO2 = new FreelancerDTO();
        assertThat(freelancerDTO1).isNotEqualTo(freelancerDTO2);
        freelancerDTO2.setId(freelancerDTO1.getId());
        assertThat(freelancerDTO1).isEqualTo(freelancerDTO2);
        freelancerDTO2.setId(2L);
        assertThat(freelancerDTO1).isNotEqualTo(freelancerDTO2);
        freelancerDTO1.setId(null);
        assertThat(freelancerDTO1).isNotEqualTo(freelancerDTO2);
    }
}
