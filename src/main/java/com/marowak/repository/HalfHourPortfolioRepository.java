package com.marowak.repository;

import com.marowak.entity.portfolio.HalfHourPortfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HalfHourPortfolioRepository extends CrudRepository<HalfHourPortfolio, Long> {
}
