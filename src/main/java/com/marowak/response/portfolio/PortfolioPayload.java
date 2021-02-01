package com.marowak.response.portfolio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioPayload implements Serializable {
    private List<PortfolioItemResponse> positions  = new ArrayList<>();

    public List<PortfolioItemResponse> getPositions() {
        return positions;
    }

    public void setPositions(List<PortfolioItemResponse> positions) {
        this.positions = positions;
    }
}
