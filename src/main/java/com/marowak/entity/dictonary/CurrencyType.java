package com.marowak.entity.dictonary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "currency_type")
public class CurrencyType  implements Serializable {

    public static final int CURRENCY_TYPE_RUB = 1;
    public static final int CURRENCY_TYPE_USD = 2;

    @Id
    private int id;

    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String type) {
        this.name = type;
    }
}
