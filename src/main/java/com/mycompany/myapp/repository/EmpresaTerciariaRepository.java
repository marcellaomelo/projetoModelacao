package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.EmpresaTerciaria;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the EmpresaTerciaria entity.
 */
@SuppressWarnings("unused")
@Repository
public interface EmpresaTerciariaRepository extends JpaRepository<EmpresaTerciaria, Long> {}
