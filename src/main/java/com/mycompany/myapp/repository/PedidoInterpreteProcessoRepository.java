package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.PedidoInterpreteProcesso;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the PedidoInterpreteProcesso entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PedidoInterpreteProcessoRepository extends JpaRepository<PedidoInterpreteProcesso, Long> {
    Optional<PedidoInterpreteProcesso> findByProcessInstanceId(Long processInstanceId);
}
