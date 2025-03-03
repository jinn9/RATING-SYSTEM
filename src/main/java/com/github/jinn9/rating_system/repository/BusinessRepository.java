package com.github.jinn9.rating_system.repository;

import com.github.jinn9.rating_system.domain.Business;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusinessRepository extends JpaRepository<Business, Long>, BusinessCustomRepository {
}
