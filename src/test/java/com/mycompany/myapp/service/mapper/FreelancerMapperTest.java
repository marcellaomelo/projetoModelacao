package com.mycompany.myapp.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FreelancerMapperTest {

    private FreelancerMapper freelancerMapper;

    @BeforeEach
    public void setUp() {
        freelancerMapper = new FreelancerMapperImpl();
    }
}
