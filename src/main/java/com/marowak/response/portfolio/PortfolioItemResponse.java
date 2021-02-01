package com.marowak.response.portfolio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class PortfolioItemResponse implements Serializable {

    private String figi;
    private String ticker;
    private String isin;
    private String instrumentType;
    private String name;

    private Long balance;
    private Long blocked;
    private Long lots;

    @JsonProperty("expectedYield")
    private PriceInfo yieldPrice;

    @JsonProperty("positionPrice")
    private PriceInfo positionPrice;


    public String getFigi() {
        return figi;
    }

    public void setFigi(String figi) {
        this.figi = figi;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getIsin() {
        return isin;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Long getBlocked() {
        return blocked;
    }

    public void setBlocked(Long blocked) {
        this.blocked = blocked;
    }

    public Long getLots() {
        return lots;
    }

    public void setLots(Long lots) {
        this.lots = lots;
    }

    public PriceInfo getYieldPrice() {
        return yieldPrice;
    }

    public void setYieldPrice(PriceInfo yieldPrice) {
        this.yieldPrice = yieldPrice;
    }

    public PriceInfo getPositionPrice() {
        return positionPrice;
    }

    public void setPositionPrice(PriceInfo positionPrice) {
        this.positionPrice = positionPrice;
    }

}
