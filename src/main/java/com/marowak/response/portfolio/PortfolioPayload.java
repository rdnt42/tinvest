package com.marowak.response.portfolio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioPayload implements Serializable {
    private List<PortfolioItem> positions  = new ArrayList<>();

    public List<PortfolioItem> getPositions() {
        return positions;
    }

    public void setPositions(List<PortfolioItem> positions) {
        this.positions = positions;
    }
}
