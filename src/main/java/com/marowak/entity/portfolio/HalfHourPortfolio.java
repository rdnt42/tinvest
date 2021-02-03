package com.marowak.entity.portfolio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "half_hour_portfolio")
public class HalfHourPortfolio extends Portfolio {
    public HalfHourPortfolio() {
    }

    public HalfHourPortfolio(Portfolio portfolio) {
        super(portfolio);
    }
}
