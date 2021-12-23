package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PedidoInterpreteMapperTest {

    private PedidoInterpreteMapper pedidoInterpreteMapper;

    @BeforeEach
    public void setUp() {
        pedidoInterpreteMapper = new PedidoInterpreteMapperImpl();
    }
}
