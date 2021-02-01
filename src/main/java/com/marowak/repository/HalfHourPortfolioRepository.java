package com.marowak.repository;

import com.marowak.entity.portfolio.HalfHourPortfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HalfHourPortfolioRepository extends JpaRepository<HalfHourPortfolio, Long> {
}
