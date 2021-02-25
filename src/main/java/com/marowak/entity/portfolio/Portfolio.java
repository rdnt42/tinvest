package com.marowak.entity.portfolio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Portfolio implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "time_stamp")
    private Date timeStamp = new Date();

    @OneToMany(cascade = CascadeType.ALL)
    private Set<PortfolioItem> portfolioItems = new HashSet<>();

    public Portfolio() {
    }

    public Portfolio(Portfolio portfolio) {
        this.id = portfolio.id;
        this.timeStamp = portfolio.timeStamp;
        this.portfolioItems = portfolio.portfolioItems;
    }

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

    public Set<PortfolioItem> getPortfolioItems() {
        return portfolioItems;
    }

    public void setPortfolioItems(Set<PortfolioItem> portfolioItems) {
        this.portfolioItems = portfolioItems;
    }
}
