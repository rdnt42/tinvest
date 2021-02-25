package com.marowak.repository;

import com.marowak.entity.portfolio.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Long> {
    List<PortfolioItem> findAllByTicker(String ticker);
}
