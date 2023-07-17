package com.cac.HomeBanking.domain.repositories;

import com.cac.HomeBanking.domain.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransfersRepository extends JpaRepository<Transfer, Long> {
}
