package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.Freelancer;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Freelancer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, Long> {}
