package com.mycompany.myapp.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.mycompany.myapp.web.rest.TestUtil;
import org.junit.jupiter.api.Test;

class PedidoInterpreteTest {

    @Test
    void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(PedidoInterprete.class);
        PedidoInterprete pedidoInterprete1 = new PedidoInterprete();
        pedidoInterprete1.setId(1L);
        PedidoInterprete pedidoInterprete2 = new PedidoInterprete();
        pedidoInterprete2.setId(pedidoInterprete1.getId());
        assertThat(pedidoInterprete1).isEqualTo(pedidoInterprete2);
        pedidoInterprete2.setId(2L);
        assertThat(pedidoInterprete1).isNotEqualTo(pedidoInterprete2);
        pedidoInterprete1.setId(null);
        assertThat(pedidoInterprete1).isNotEqualTo(pedidoInterprete2);
    }
}
