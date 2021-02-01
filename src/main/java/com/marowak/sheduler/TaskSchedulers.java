package com.marowak.sheduler;

import com.marowak.entity.portfolio.Portfolio;
import com.marowak.repository.FiveMinutesPortfolioRepository;
import com.marowak.repository.HalfHourPortfolioRepository;
import com.marowak.repository.OneMinutePortfolioRepository;
import com.marowak.service.PortfolioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@Component
public class TaskSchedulers {
    private static final Logger log = LoggerFactory.getLogger(TaskSchedulers.class);

    private static final int MINUTE = 60 * 1000;

    public static Portfolio currentPortfolio = null;

    final
    OneMinutePortfolioRepository oneMinutePortfolioRepository;

    final
    FiveMinutesPortfolioRepository fiveMinutesPortfolioRepository;

    final
    HalfHourPortfolioRepository halfHourPortfolioRepository;

    final
    PortfolioService portfolioService;

    public TaskSchedulers(OneMinutePortfolioRepository oneMinutePortfolioRepository, FiveMinutesPortfolioRepository fiveMinutesPortfolioRepository, HalfHourPortfolioRepository halfHourPortfolioRepository, PortfolioService portfolioService) {
        this.oneMinutePortfolioRepository = oneMinutePortfolioRepository;
        this.fiveMinutesPortfolioRepository = fiveMinutesPortfolioRepository;
        this.halfHourPortfolioRepository = halfHourPortfolioRepository;
        this.portfolioService = portfolioService;
    }

    @Scheduled(fixedRate = 5000)
    public void getPortfolioScheduler() {

        Portfolio portfolio = portfolioService.getPortfolioREST();

        if (portfolio != null) {
            currentPortfolio = portfolio;
        }

        log.info("Get portfolio, size: " + currentPortfolio.getPortfolioItems().size());

    }

    @Scheduled(fixedRate = MINUTE)
    public void getPortfolioMinuteScheduler() {
        assertThat(currentPortfolio, is(notNullValue()));

//        Portfolio currentPortfolio = new
//        oneMinutePortfolioRepository.save(currentPortfolio);

        log.info("Save minute: ");

    }
}
