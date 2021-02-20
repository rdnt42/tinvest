package com.marowak.service;

import com.marowak.constant.Urls;
import com.marowak.decoder.PortfolioDecoder;
import com.marowak.encoder.PortfolioEncoder;
import com.marowak.entity.portfolio.FiveMinutesPortfolio;
import com.marowak.entity.portfolio.HalfHourPortfolio;
import com.marowak.entity.portfolio.OneMinutePortfolio;
import com.marowak.entity.portfolio.Portfolio;
import com.marowak.repository.FiveMinutesPortfolioRepository;
import com.marowak.repository.HalfHourPortfolioRepository;
import com.marowak.repository.OneMinutePortfolioRepository;
import com.marowak.response.portfolio.PortfolioResponse;
import com.marowak.response.portfolioTink.PortfolioTinkResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    private static final Logger log = LoggerFactory.getLogger(PortfolioServiceImpl.class);


    private final PortfolioDecoder portfolioDecoder;
    private final PortfolioEncoder portfolioEncoder;

    private final OneMinutePortfolioRepository oneMinutePortfolioRepository;
    private final FiveMinutesPortfolioRepository fiveMinutesPortfolioRepository;
    private final HalfHourPortfolioRepository halfHourPortfolioRepository;


    public PortfolioServiceImpl(PortfolioDecoder portfolioDecoder, PortfolioEncoder portfolioEncoder,
                                OneMinutePortfolioRepository oneMinutePortfolioRepository,
                                FiveMinutesPortfolioRepository fiveMinutesPortfolioRepository, HalfHourPortfolioRepository halfHourPortfolioRepository) {
        this.portfolioDecoder = portfolioDecoder;
        this.portfolioEncoder = portfolioEncoder;
        this.oneMinutePortfolioRepository = oneMinutePortfolioRepository;
        this.fiveMinutesPortfolioRepository = fiveMinutesPortfolioRepository;
        this.halfHourPortfolioRepository = halfHourPortfolioRepository;
    }

    @Override
    public PortfolioTinkResponse getPortfolioREST() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        // add to Pass environment variables(edit config)
        headers.set("Authorization", "Bearer " + System.getenv("VUE_APP_SECRET_TOKEN"));

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<PortfolioTinkResponse> response = restTemplate.exchange(Urls.GET_PORTFOLIO, HttpMethod.GET, entity, PortfolioTinkResponse.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        return response.getBody();
    }

    @Override
    public <T> boolean savePortfolio(PortfolioTinkResponse response, Class<T> c) {
        assertThat(response, is(notNullValue()));

        Portfolio portfolio = portfolioDecoder.decode(response);

        if (OneMinutePortfolio.class.equals(c)) {
            OneMinutePortfolio oneMinutePortfolio = new OneMinutePortfolio(portfolio);
            oneMinutePortfolioRepository.save(oneMinutePortfolio);

            log.info("Save minute portfolio, id: {}", oneMinutePortfolio.getId());
        } else if (FiveMinutesPortfolio.class.equals(c)) {
            FiveMinutesPortfolio fiveMinutesPortfolio = new FiveMinutesPortfolio(portfolio);
            fiveMinutesPortfolioRepository.save(fiveMinutesPortfolio);

            log.info("Save five minutes portfolio, id: {}", fiveMinutesPortfolio.getId());
        } else if (HalfHourPortfolio.class.equals(c)) {
            HalfHourPortfolio halfHourPortfolio = new HalfHourPortfolio(portfolio);
            halfHourPortfolioRepository.save(halfHourPortfolio);

            log.info("Save hal hour portfolio, id: {}", halfHourPortfolio.getId());
        } else {
            throw new IllegalArgumentException("Unknown portfolio class");
        }

        return true;
    }

    @Override
    public List<PortfolioResponse> getAll() {
        List<OneMinutePortfolio> portfolios = oneMinutePortfolioRepository.findAll();
        List<PortfolioResponse> responses = new ArrayList<>();

        for (OneMinutePortfolio portfolio : portfolios) {
            PortfolioResponse response = portfolioEncoder.encode(portfolio);

            responses.add(response);
        }

        return responses;
    }

    @Override
    public PortfolioResponse getLast() {
        OneMinutePortfolio item = oneMinutePortfolioRepository.findFirstByOrderByIdDesc();

        return portfolioEncoder.encode(item);
    }
}
