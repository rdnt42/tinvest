package com.marowak.repository;

import com.marowak.entity.portfolio.FiveMinutesPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiveMinutesPortfolioRepository extends JpaRepository<FiveMinutesPortfolio, Long> {
}
