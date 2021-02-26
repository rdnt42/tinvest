package com.marowak.encoder;

import com.marowak.entity.portfolio.Portfolio;
import com.marowak.entity.portfolio.PortfolioItem;
import com.marowak.response.portfolio.PortfolioItemResponse;
import com.marowak.response.portfolio.PortfolioResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioEncoder {

    private final PortfolioItemEncoder portfolioItemEncoder;

    public PortfolioEncoder(PortfolioItemEncoder portfolioItemEncoder) {
        this.portfolioItemEncoder = portfolioItemEncoder;
    }

    public PortfolioResponse encode(Portfolio portfolio) {
        PortfolioResponse response = new PortfolioResponse();

        if (portfolio == null) {
            return response;
        }

        response.setId(portfolio.getId());
        response.setTimeStamp(portfolio.getTimeStamp());

        List<PortfolioItemResponse> itemResponses = new ArrayList<>();
        for (PortfolioItem item : portfolio.getPortfolioItems()) {
            PortfolioItemResponse itemResponse = portfolioItemEncoder.encode(item);

            itemResponses.add(itemResponse);
        }

        response.setItems(itemResponses);

        return response;
    }
}
