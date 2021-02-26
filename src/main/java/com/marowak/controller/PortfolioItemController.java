package com.marowak.controller;

import com.marowak.response.portfolio.PortfolioItemResponse;
import com.marowak.service.PortfolioItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class PortfolioItemController {

    private final PortfolioItemService portfolioItemService;

    public PortfolioItemController(PortfolioItemService portfolioItemService) {
        this.portfolioItemService = portfolioItemService;
    }

    @GetMapping("/portfolio_item")
    public List<PortfolioItemResponse> get(@RequestParam String ticker,
                                           @RequestParam(name = "slice_type") int sliceType) {

        return portfolioItemService.get(ticker, sliceType);
    }
}
