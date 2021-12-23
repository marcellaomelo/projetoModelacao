package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.PedidoInterprete;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the PedidoInterprete entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PedidoInterpreteRepository extends JpaRepository<PedidoInterprete, Long> {}
