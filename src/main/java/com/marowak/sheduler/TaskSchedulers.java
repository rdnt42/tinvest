package com.marowak.sheduler;

import com.marowak.entity.portfolio.FiveMinutesPortfolio;
import com.marowak.entity.portfolio.HalfHourPortfolio;
import com.marowak.entity.portfolio.OneMinutePortfolio;
import com.marowak.entity.portfolio.Portfolio;
import com.marowak.repository.PortfolioItemRepository;
import com.marowak.response.portfolioTink.PortfolioTinkResponse;
import com.marowak.service.PortfolioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskSchedulers {
    private static final Logger log = LoggerFactory.getLogger(TaskSchedulers.class);

    private static final int GET_EVERY_IN_SEC = 5 * 1000;
    private static final int GET_IN_MINUTE = 60 * 1000;
    private static final int GET_IN_FIVE_MINUTES = 5 * 60 * 1000;
    private static final int GET_IN_HALF_HOUR = 60 * 60 * 1000;


    private PortfolioTinkResponse currentResponse = null;

    private final PortfolioService portfolioService;
    final PortfolioItemRepository portfolioItemRepository;

    public TaskSchedulers(PortfolioService portfolioService, PortfolioItemRepository portfolioItemRepository) {
        this.portfolioService = portfolioService;
        this.portfolioItemRepository = portfolioItemRepository;
    }

    @Scheduled(fixedRate = GET_EVERY_IN_SEC)
    public void getPortfolioScheduler() {
        PortfolioTinkResponse response = portfolioService.getPortfolioREST();

        if (response != null) {
            currentResponse = response;
        }

//        log.info("Get portfolio, size: {}", currentPortfolio.getPortfolioItems().size());
    }

    @Scheduled(fixedRate = GET_IN_MINUTE)
    public void getPortfolioMinuteScheduler() {
        portfolioService.savePortfolio(currentResponse, OneMinutePortfolio.class);
    }

    @Scheduled(fixedRate = GET_IN_FIVE_MINUTES)
    public void getPortfolioFiveMinutesScheduler() {
        portfolioService.savePortfolio(currentResponse, FiveMinutesPortfolio.class);
    }

    @Scheduled(fixedRate = GET_IN_HALF_HOUR)
    public void getPortfolioHalfHourScheduler() {
        portfolioService.savePortfolio(currentResponse, HalfHourPortfolio.class);
    }
}
