package com.marowak.repository;

import com.marowak.entity.portfolio.OneMinutePortfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneMinutePortfolioRepository extends JpaRepository<OneMinutePortfolio, Long> {

}
