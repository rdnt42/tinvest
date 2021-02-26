package com.marowak.repository;

import com.marowak.entity.portfolio.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Integer> {
    List<PortfolioItem> findAllByTicker(String ticker);
    List<PortfolioItem> findAllByTickerAndSliceTypeId(String ticker, int sliceTypeId);
}
