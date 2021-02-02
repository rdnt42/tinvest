package com.marowak.entity.portfolio;

import com.marowak.entity.dictonary.CurrencyType;

import javax.persistence.*;

@Entity
@Table(name = "portfolio_item")
public class PortfolioItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private Long balance;

//    @Column(name = "blocked")
//    private Long blocked;

//    @Column(name = "lots")
//    private Long lots;

    @Column(name = "yield_price")
    private Double yeildPrice;

    @Column(name = "position_price")
    private Double positionPrice;

    @Column(name = "currency_type_id")
    private Long currencyTypeId;

    @ManyToOne
    @JoinColumn(name = "currency_type_id", insertable = false, updatable = false)
    private CurrencyType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CurrencyType getType() {
        return type;
    }

    public void setType(CurrencyType type) {
        this.type = type;
    }
}
