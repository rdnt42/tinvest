package com.marowak.service;

import com.marowak.response.portfolio.PortfolioResponse;
import com.marowak.response.portfolioTink.PortfolioTinkResponse;

import java.util.List;

public interface PortfolioService {

    /**
     * get current value of user portfolio from tink api
     * @return Portfolio response
     */
    PortfolioTinkResponse getPortfolioREST();

    <T> boolean savePortfolio(PortfolioTinkResponse response, Class<T> c);

    List<PortfolioResponse> getAll();

    PortfolioResponse getLast();

}
