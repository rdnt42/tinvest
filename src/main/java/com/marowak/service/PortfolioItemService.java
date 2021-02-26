package com.marowak.service;

import com.marowak.response.portfolio.PortfolioItemResponse;

import java.util.List;

public interface PortfolioItemService {
    List<PortfolioItemResponse> get(String ticker, Long sliceTypeId);
}
