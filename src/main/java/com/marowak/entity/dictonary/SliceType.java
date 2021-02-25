package com.marowak.entity.dictonary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "slice_type")
public class SliceType implements Serializable {
    public static final Long SLICE_TYPE_MINUTE = 1L;
    public static final Long SLICE_TYPE_FIVE_MINUTES = 2L;
    public static final Long SLICE_TYPE_HAL_HOUR = 3L;

    @Id
    private Long id;

    @Column(name = "name")
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

    public void setName(String name) {
        this.name = name;
    }
}
