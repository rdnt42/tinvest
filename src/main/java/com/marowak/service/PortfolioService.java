package com.marowak.service;

import com.marowak.entity.portfolio.Portfolio;

public interface PortfolioService {

    /**
     * get current value of user portfolio from tink api
     * @return Portfolio object
     */
    Portfolio getPortfolioREST();

}
