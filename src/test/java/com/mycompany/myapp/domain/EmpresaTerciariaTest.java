package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class EmpresaTerciariaTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(EmpresaTerciaria.class);
        EmpresaTerciaria empresaTerciaria1 = new EmpresaTerciaria();
        empresaTerciaria1.setId(1L);
        EmpresaTerciaria empresaTerciaria2 = new EmpresaTerciaria();
        empresaTerciaria2.setId(empresaTerciaria1.getId());
        assertThat(empresaTerciaria1).isEqualTo(empresaTerciaria2);
        empresaTerciaria2.setId(2L);
        assertThat(empresaTerciaria1).isNotEqualTo(empresaTerciaria2);
        empresaTerciaria1.setId(null);
        assertThat(empresaTerciaria1).isNotEqualTo(empresaTerciaria2);
    }
}
