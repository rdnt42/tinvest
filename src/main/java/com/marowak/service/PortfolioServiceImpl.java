package com.marowak.service;

import com.marowak.constant.Urls;
import com.marowak.decoder.PortfolioDecoder;
import com.marowak.encoder.PortfolioEncoder;
import com.marowak.entity.portfolio.OneMinutePortfolio;
import com.marowak.entity.portfolio.Portfolio;
import com.marowak.repository.OneMinutePortfolioRepository;
import com.marowak.response.portfolio.PortfolioResponse;
import com.marowak.response.portfolioTink.PortfolioTinkResponse;
import com.marowak.token.BearerToken;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioDecoder portfolioDecoder;
    private final PortfolioEncoder portfolioEncoder;
    private final OneMinutePortfolioRepository oneMinutePortfolioRepository;

    public PortfolioServiceImpl(PortfolioDecoder portfolioDecoder, PortfolioEncoder portfolioEncoder, OneMinutePortfolioRepository oneMinutePortfolioRepository) {
        this.portfolioDecoder = portfolioDecoder;
        this.portfolioEncoder = portfolioEncoder;
        this.oneMinutePortfolioRepository = oneMinutePortfolioRepository;
    }

    @Override
    public Portfolio getPortfolioREST() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set("Authorization", "Bearer " + BearerToken.secretToken);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<PortfolioTinkResponse> response = restTemplate.exchange(Urls.GET_PORTFOLIO, HttpMethod.GET, entity, PortfolioTinkResponse.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        PortfolioTinkResponse portfolioTinkResponse = response.getBody();

        return portfolioDecoder.decode(portfolioTinkResponse);
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
}
