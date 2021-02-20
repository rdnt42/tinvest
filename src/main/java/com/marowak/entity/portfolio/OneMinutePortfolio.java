package com.marowak.entity.portfolio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "one_minute_portfolio")
public class OneMinutePortfolio extends Portfolio {
    public OneMinutePortfolio() {
    }

    public OneMinutePortfolio(Portfolio portfolio) {
        super(portfolio);
    }
}
