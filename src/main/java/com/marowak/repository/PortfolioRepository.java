package com.marowak.repository;

import com.marowak.entity.portfolio.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
    Portfolio findFirstByOrderByIdDesc();
}
