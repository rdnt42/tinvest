package com.marowak.repository;

import com.marowak.entity.portfolio.OneMinutePortfolio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OneMinutePortfolioRepository extends CrudRepository<OneMinutePortfolio, Long> {

}
