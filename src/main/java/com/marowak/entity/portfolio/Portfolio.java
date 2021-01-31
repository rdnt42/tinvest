package com.marowak.entity.portfolio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Portfolio implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "figi")
    private String figi;

    @Column(name = "ticker")
    private String ticker;

    @Column(name = "isin")
    private String isin;

    @Column(name = "instrumentType")
    private String instrumentType;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "blocked")
    private Long blocked;

    @Column(name = "lots")
    private Long lots;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
