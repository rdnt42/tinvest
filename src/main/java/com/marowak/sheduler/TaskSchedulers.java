package com.marowak.sheduler;

import com.marowak.constant.Urls;
import com.marowak.repository.FiveMinutesPortfolioRepository;
import com.marowak.repository.HalfHourPortfolioRepository;
import com.marowak.repository.OneMinutePortfolioRepository;
import com.marowak.response.portfolio.PortfolioResponse;
import com.marowak.token.BearerToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Component
public class TaskSchedulers {
    private static final Logger log = LoggerFactory.getLogger(TaskSchedulers.class);

    private static final Long MINUTE = 1000 * 60L;

    public static PortfolioResponse currentPortfolio = null;

    final
    OneMinutePortfolioRepository oneMinutePortfolioRepository;

    final
    FiveMinutesPortfolioRepository fiveMinutesPortfolioRepository;

    final
    HalfHourPortfolioRepository halfHourPortfolioRepository;

    public TaskSchedulers(OneMinutePortfolioRepository oneMinutePortfolioRepository, FiveMinutesPortfolioRepository fiveMinutesPortfolioRepository, HalfHourPortfolioRepository halfHourPortfolioRepository) {
        this.oneMinutePortfolioRepository = oneMinutePortfolioRepository;
        this.fiveMinutesPortfolioRepository = fiveMinutesPortfolioRepository;
        this.halfHourPortfolioRepository = halfHourPortfolioRepository;
    }

    @Scheduled(fixedRate = 5000)
    public void getPortfolioScheduler() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set("Authorization", "Bearer " + BearerToken.secretToken);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<PortfolioResponse> response = restTemplate.exchange(Urls.GET_PORTFOLIO, HttpMethod.GET, entity, PortfolioResponse.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        currentPortfolio = response.getBody();

        log.info("Status: " + currentPortfolio.getStatus());

    }

    @Scheduled(fixedRate = MINUTE)
    public void getPortfolioMinuteScheduler() {
        assertThat(currentPortfolio, is(notNullValue()));

//        Portfolio currentPortfolio = new
//        oneMinutePortfolioRepository.save(currentPortfolio);

//        log.info("Save minute: " + currentResponse.getStatus());

    }
}
