package com.marowak.repository;

import com.marowak.entity.portfolio.FiveMinutesPortfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FiveMinutesPortfolioRepository extends CrudRepository<FiveMinutesPortfolio, Long> {
}
