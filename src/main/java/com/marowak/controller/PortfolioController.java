package com.marowak.controller;

import com.marowak.response.portfolio.PortfolioItemResponse;
import com.marowak.response.portfolio.PortfolioResponse;
import com.marowak.service.PortfolioService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @GetMapping("/portfolio/last")
    public PortfolioResponse getLast() {
        return portfolioService.getLast();
    }

    @GetMapping("/portfolio/all")
    public List<PortfolioResponse> getAll() {
        return portfolioService.getAll();
    }

    @GetMapping("/portfolio/{id}/item/")
    public List<PortfolioItemResponse> getItem(@RequestParam (name = "slice_type") Long sliceType) {
        return null;
    }
}
