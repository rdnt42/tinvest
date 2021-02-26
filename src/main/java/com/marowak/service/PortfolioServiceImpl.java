package com.marowak.service;

import com.marowak.constant.Urls;
import com.marowak.decoder.PortfolioDecoder;
import com.marowak.encoder.PortfolioEncoder;
import com.marowak.entity.dictonary.SliceType;
import com.marowak.entity.portfolio.Portfolio;
import com.marowak.repository.PortfolioRepository;
import com.marowak.repository.dictonary.SliceTypeRepository;
import com.marowak.response.portfolio.PortfolioResponse;
import com.marowak.response.portfolioTink.PortfolioTinkResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Service
public class PortfolioServiceImpl implements PortfolioService {
    private static final Logger log = LoggerFactory.getLogger(PortfolioServiceImpl.class);


    private final PortfolioDecoder portfolioDecoder;
    private final PortfolioEncoder portfolioEncoder;


    private final PortfolioRepository portfolioRepository;
    private final SliceTypeRepository sliceTypeRepository;


    public PortfolioServiceImpl(PortfolioDecoder portfolioDecoder, PortfolioEncoder portfolioEncoder,
                                PortfolioRepository portfolioRepository, SliceTypeRepository sliceTypeRepository) {
        this.portfolioDecoder = portfolioDecoder;
        this.portfolioEncoder = portfolioEncoder;
        this.portfolioRepository = portfolioRepository;
        this.sliceTypeRepository = sliceTypeRepository;
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
    @Transactional
    public boolean savePortfolio(PortfolioTinkResponse response, int sliceTypeId) {
        assertThat(response, is(notNullValue()));
        SliceType sliceType = sliceTypeRepository.findById(sliceTypeId).orElse(null);
        assertThat(sliceType, is(notNullValue()));

        Portfolio portfolio = portfolioDecoder.decode(response, sliceType);
        portfolioRepository.save(portfolio);

        log.info("Save {} portfolio, id: {}", sliceType.getName(), portfolio.getId());
        return true;
    }

    @Override
    public List<PortfolioResponse> getAll() {
        List<PortfolioResponse> responses = new ArrayList<>();

        List<Portfolio> portfolios = portfolioRepository.findAll();
        for (Portfolio portfolio : portfolios) {
            PortfolioResponse response = portfolioEncoder.encode(portfolio);

            responses.add(response);
        }

        return responses;
    }

    @Override
    public PortfolioResponse getLast() {
        Portfolio portfolio = portfolioRepository.findFirstByOrderByIdDesc();

        return portfolioEncoder.encode(portfolio);
    }

}
