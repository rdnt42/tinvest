package com.marowak.service;

import com.marowak.entity.portfolio.Portfolio;
import com.marowak.response.portfolio.PortfolioResponse;

import java.util.List;

public interface PortfolioService {

    /**
     * get current value of user portfolio from tink api
     * @return Portfolio object
     */
    Portfolio getPortfolioREST();

    List<PortfolioResponse> getAll();


}
