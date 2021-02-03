package com.marowak.response.portfolioTink;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioTinkPayload implements Serializable {
    private List<PortfolioTinkItemResponse> positions  = new ArrayList<>();

    public List<PortfolioTinkItemResponse> getPositions() {
        return positions;
    }

    public void setPositions(List<PortfolioTinkItemResponse> positions) {
        this.positions = positions;
    }
}
