package com.marowak.service;

import com.marowak.encoder.PortfolioItemEncoder;
import com.marowak.entity.portfolio.PortfolioItem;
import com.marowak.repository.PortfolioItemRepository;
import com.marowak.response.portfolio.PortfolioItemResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioItemServiceImpl implements PortfolioItemService {

    private final PortfolioItemRepository portfolioItemRepository;
    private final PortfolioItemEncoder portfolioItemEncoder;

    public PortfolioItemServiceImpl(PortfolioItemRepository portfolioItemRepository, PortfolioItemEncoder portfolioItemEncoder) {
        this.portfolioItemRepository = portfolioItemRepository;
        this.portfolioItemEncoder = portfolioItemEncoder;
    }

    @Override
    public List<PortfolioItemResponse> get(String ticker, int sliceTypeId) {
        List<PortfolioItem> items = portfolioItemRepository.findAllByTickerAndSliceTypeId(ticker, sliceTypeId);

        List<PortfolioItemResponse> responses = new ArrayList<>();
        for (PortfolioItem item : items) {
            PortfolioItemResponse response = portfolioItemEncoder.encode(item);

            if (response != null) {
                responses.add(response);
            }
        }

        return responses;
    }
}
