package com.mycompany.myapp.service.dto;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PedidoInterpreteDTOTest {

    @Test
    void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PedidoInterpreteDTO.class);
        PedidoInterpreteDTO pedidoInterpreteDTO1 = new PedidoInterpreteDTO();
        pedidoInterpreteDTO1.setId(1L);
        PedidoInterpreteDTO pedidoInterpreteDTO2 = new PedidoInterpreteDTO();
        assertThat(pedidoInterpreteDTO1).isNotEqualTo(pedidoInterpreteDTO2);
        pedidoInterpreteDTO2.setId(pedidoInterpreteDTO1.getId());
        assertThat(pedidoInterpreteDTO1).isEqualTo(pedidoInterpreteDTO2);
        pedidoInterpreteDTO2.setId(2L);
        assertThat(pedidoInterpreteDTO1).isNotEqualTo(pedidoInterpreteDTO2);
        pedidoInterpreteDTO1.setId(null);
        assertThat(pedidoInterpreteDTO1).isNotEqualTo(pedidoInterpreteDTO2);
    }
}
