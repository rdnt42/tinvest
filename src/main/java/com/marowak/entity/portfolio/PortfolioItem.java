package com.marowak.entity.portfolio;

import com.marowak.entity.dictonary.CurrencyType;
import com.marowak.entity.dictonary.SliceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "portfolio_item")
public class PortfolioItem implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Portfolio portfolio;

    @Column(name = "time_stamp")
    private Date timeStamp = new Date();

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "yield_price")
    private Double yeildPrice;

    @Column(name = "position_price")
    private Double positionPrice;

    @Column(name = "currency_type_id", insertable = false, updatable = false)
    private Long currencyTypeId;

    @ManyToOne
    @JoinColumn(name = "currency_type_id")
    private CurrencyType currencyType;

    @ManyToOne
    @JoinColumn(name = "slice_type_id")
    private SliceType sliceType;

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

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
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

    public Long getCurrencyTypeId() {
        return currencyTypeId;
    }

    public void setCurrencyTypeId(Long currencyTypeId) {
        this.currencyTypeId = currencyTypeId;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public SliceType getSliceType() {
        return sliceType;
    }

    public void setSliceType(SliceType sliceType) {
        this.sliceType = sliceType;
    }
}
