package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class EmpresaTerciariaDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmpresaTerciariaDTO.class);
        EmpresaTerciariaDTO empresaTerciariaDTO1 = new EmpresaTerciariaDTO();
        empresaTerciariaDTO1.setId(1L);
        EmpresaTerciariaDTO empresaTerciariaDTO2 = new EmpresaTerciariaDTO();
        assertThat(empresaTerciariaDTO1).isNotEqualTo(empresaTerciariaDTO2);
        empresaTerciariaDTO2.setId(empresaTerciariaDTO1.getId());
        assertThat(empresaTerciariaDTO1).isEqualTo(empresaTerciariaDTO2);
        empresaTerciariaDTO2.setId(2L);
        assertThat(empresaTerciariaDTO1).isNotEqualTo(empresaTerciariaDTO2);
        empresaTerciariaDTO1.setId(null);
        assertThat(empresaTerciariaDTO1).isNotEqualTo(empresaTerciariaDTO2);
    }
}
