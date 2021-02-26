package com.marowak.entity.dictonary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "slice_type")
public class SliceType implements Serializable {
    public static final int SLICE_TYPE_MINUTE = 1;
    public static final int SLICE_TYPE_FIVE_MINUTES = 2;
    public static final int SLICE_TYPE_HALF_HOUR = 3;

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

    public void setName(String name) {
        this.name = name;
    }
}
