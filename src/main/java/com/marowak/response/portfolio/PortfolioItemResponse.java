package com.marowak.response.portfolio;

public class PortfolioItemResponse {
    private String ticker;
    private String name;
    private String type;

    private Long balance;

    private Double yeildPrice;
    private Double positionPrice;

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Double getYeildPrice() {
        return yeildPrice;
    }

    public void setYeildPrice(Double yeildPrice) {
        this.yeildPrice = yeildPrice;
    }

    public Double getPositionPrice() {
        return positionPrice;
    }

    public void setPositionPrice(Double positionPrice) {
        this.positionPrice = positionPrice;
    }
}
