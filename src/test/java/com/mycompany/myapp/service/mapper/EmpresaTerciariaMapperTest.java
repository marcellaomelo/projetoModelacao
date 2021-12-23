package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTerciariaMapperTest {

    private EmpresaTerciariaMapper empresaTerciariaMapper;

    @BeforeEach
    public void setUp() {
        empresaTerciariaMapper = new EmpresaTerciariaMapperImpl();
    }
}
