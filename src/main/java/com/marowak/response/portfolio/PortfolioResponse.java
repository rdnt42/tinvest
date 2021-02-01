package com.marowak.response.portfolio;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PortfolioResponse  implements Serializable {
    private String status;
    private String trackingId;
    private PortfolioPayload payload;

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

    public PortfolioPayload getPayload() {
        return payload;
    }

    public void setPayload(PortfolioPayload payload) {
        this.payload = payload;
    }
}
