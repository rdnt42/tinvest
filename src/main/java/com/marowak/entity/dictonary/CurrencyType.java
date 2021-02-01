package com.marowak.entity.dictonary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "currency_type")
public class CurrencyType {

    public static Long CURRENCY_TYPE_RUB = 1L;
    public static Long CURRENCY_TYPE_USD = 2L;

    @Id
    private Long id;

    @Column(name = "type")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String type) {
        this.name = type;
    }
}
