package com.marowak.response.portfolioTink;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioTinkResponse implements Serializable {
    private String status;
    private String trackingId;
    private PortfolioTinkPayload payload;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    public PortfolioTinkPayload getPayload() {
        return payload;
    }

    public void setPayload(PortfolioTinkPayload payload) {
        this.payload = payload;
    }
}
