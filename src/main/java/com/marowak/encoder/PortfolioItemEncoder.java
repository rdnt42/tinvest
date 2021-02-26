package com.marowak.encoder;

import com.marowak.entity.portfolio.PortfolioItem;
import com.marowak.response.portfolio.PortfolioItemResponse;
import org.springframework.stereotype.Service;

@Service
public class PortfolioItemEncoder {

    public PortfolioItemResponse encode(PortfolioItem item) {
        PortfolioItemResponse response = new PortfolioItemResponse();

        if (item == null) {
            return response;
        }

        response.setTicker(item.getTicker());
        response.setName(item.getName());
        response.setType(item.getCurrencyType().getName());
        response.setBalance(item.getBalance());
        response.setYeildPrice(item.getYeildPrice());
        response.setPositionPrice(item.getPositionPrice());

        return response;
    }

}
