package com.marowak.sheduler;

import com.marowak.entity.dictonary.SliceType;
import com.marowak.response.portfolioTink.PortfolioTinkResponse;
import com.marowak.service.PortfolioService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskSchedulers {

    private static final int GET_EVERY_IN_SEC = 5 * 1000;
    private static final int GET_IN_MINUTE = 60 * 1000;
    private static final int GET_IN_FIVE_MINUTES = 5 * 60 * 1000;
    private static final int GET_IN_HALF_HOUR = 60 * 60 * 1000;

    private PortfolioTinkResponse currentResponse = null;

    private final PortfolioService portfolioService;

    public TaskSchedulers(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    @Scheduled(fixedRate = GET_EVERY_IN_SEC)
    public void getPortfolioScheduler() {
        PortfolioTinkResponse response = portfolioService.getPortfolioREST();

        if (response != null) {
            currentResponse = response;
        }
    }

    @Scheduled(fixedRate = GET_IN_MINUTE)
    public void getPortfolioMinuteScheduler() {
        portfolioService.savePortfolio(currentResponse, SliceType.SLICE_TYPE_MINUTE);
    }

    @Scheduled(fixedRate = GET_IN_FIVE_MINUTES)
    public void getPortfolioFiveMinutesScheduler() {
        portfolioService.savePortfolio(currentResponse, SliceType.SLICE_TYPE_HALF_HOUR);
    }

    @Scheduled(fixedRate = GET_IN_HALF_HOUR)
    public void getPortfolioHalfHourScheduler() {
        portfolioService.savePortfolio(currentResponse, SliceType.SLICE_TYPE_HALF_HOUR);
    }
}
