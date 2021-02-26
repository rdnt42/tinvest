package com.marowak.entity.portfolio;

import com.marowak.entity.dictonary.SliceType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "portfolio")
public class Portfolio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "time_stamp")
    private Date timeStamp = new Date();

    @ManyToOne
    @JoinColumn(name = "slice_type_id")
    private SliceType sliceType;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "portfolio")
    private Set<PortfolioItem> portfolioItems = new HashSet<>();

    public Portfolio() {
    }

    public Portfolio(Portfolio portfolio) {
        this.id = portfolio.id;
        this.timeStamp = portfolio.timeStamp;
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

    public SliceType getSliceType() {
        return sliceType;
    }

    public void setSliceType(SliceType sliceType) {
        this.sliceType = sliceType;
    }
}
