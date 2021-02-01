package com.marowak.service;

import com.marowak.constant.Urls;
import com.marowak.decoder.PortfolioDecoder;
import com.marowak.entity.portfolio.Portfolio;
import com.marowak.response.portfolio.PortfolioResponse;
import com.marowak.token.BearerToken;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    private final PortfolioDecoder portfolioDecoder;

    public PortfolioServiceImpl(PortfolioDecoder portfolioDecoder) {
        this.portfolioDecoder = portfolioDecoder;
    }

    @Override
    public Portfolio getPortfolioREST() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        headers.set("Authorization", "Bearer " + BearerToken.secretToken);

        HttpEntity<String> entity = new HttpEntity<>("body", headers);

        ResponseEntity<PortfolioResponse> response = restTemplate.exchange(Urls.GET_PORTFOLIO, HttpMethod.GET, entity, PortfolioResponse.class);
        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));

        PortfolioResponse portfolioResponse = response.getBody();

        return portfolioDecoder.decode(portfolioResponse);
    }
}
