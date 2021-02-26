package com.marowak.entity.portfolio;

import com.marowak.entity.dictonary.CurrencyType;
import com.marowak.entity.dictonary.SliceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "portfolio_item")
public class PortfolioItem implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    @Column(name = "time_stamp")
    private Date timeStamp = new Date();

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private int balance;

    @Column(name = "yield_price")
    private Double yeildPrice;

    @Column(name = "position_price")
    private Double positionPrice;

    @Column(name = "currency_type_id", insertable = false, updatable = false)
    private int currencyTypeId;


    @Column(name = "slice_type_id", insertable = false, updatable = false)
    private int sliceTypeId;

    @ManyToOne
    @JoinColumn(name = "currency_type_id")
    private CurrencyType currencyType;

    @ManyToOne
    @JoinColumn(name = "slice_type_id")
    private SliceType sliceType;

    public PortfolioItem() {
    }

    public PortfolioItem(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
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

    public int getCurrencyTypeId() {
        return currencyTypeId;
    }

    public void setCurrencyTypeId(int currencyTypeId) {
        this.currencyTypeId = currencyTypeId;
    }

    public int getSliceTypeId() {
        return sliceTypeId;
    }

    public void setSliceTypeId(int sliceTypeId) {
        this.sliceTypeId = sliceTypeId;
    }
}
