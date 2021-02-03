package com.marowak.decoder;

import com.marowak.entity.dictonary.CurrencyType;
import com.marowak.entity.portfolio.Portfolio;
import com.marowak.entity.portfolio.PortfolioItem;
import com.marowak.repository.dictonary.CurrencyTypeRepositoryImpl;
import com.marowak.response.portfolioTink.PortfolioTinkItemResponse;
import com.marowak.response.portfolioTink.PortfolioTinkResponse;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PortfolioDecoder {

    private final CurrencyTypeRepositoryImpl currencyTypeRepository;

    public PortfolioDecoder(CurrencyTypeRepositoryImpl currencyTypeRepository) {
        this.currencyTypeRepository = currencyTypeRepository;
    }

    public Portfolio decode(PortfolioTinkResponse response) {
        Portfolio portfolio = new Portfolio();

        if (response == null || response.getPayload() == null) {
            return null;
        }

        List<PortfolioTinkItemResponse> itemResponses = response.getPayload().getPositions();
        Set<PortfolioItem> items = new HashSet<>();

        for (PortfolioTinkItemResponse itemResponse : itemResponses) {
            PortfolioItem item = decode(itemResponse);

            items.add(item);
        }

        portfolio.setPortfolioItems(items);

        return portfolio;
    }

    public PortfolioItem decode(PortfolioTinkItemResponse item) {
        if (item == null) {
            return null;
        }

        PortfolioItem portfolioItem = new PortfolioItem();

        portfolioItem.setBalance(item.getBalance());
        portfolioItem.setName(item.getName());
        portfolioItem.setTicker(item.getTicker());

        if (item.getYieldPrice() != null) {
            portfolioItem.setYeildPrice(item.getYieldPrice().getValue());
        }

        if (item.getPositionPrice() != null) {
            portfolioItem.setPositionPrice(item.getPositionPrice().getValue());

            CurrencyType type = currencyTypeRepository.findOneByName(item.getPositionPrice().getCurrency());
            portfolioItem.setType(type);
        }

        return portfolioItem;
    }
}
