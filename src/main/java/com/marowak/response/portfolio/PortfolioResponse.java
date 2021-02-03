package com.marowak.response.portfolio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PortfolioResponse {
    private Long id;
    private Date timeStamp;

    private List<PortfolioItemResponse> items = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public List<PortfolioItemResponse> getItems() {
        return items;
    }

    public void setItems(List<PortfolioItemResponse> items) {
        this.items = items;
    }
}
