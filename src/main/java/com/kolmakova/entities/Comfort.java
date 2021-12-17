package com.kolmakova.entities;

import com.kolmakova.types.ComfortType;

import javax.persistence.*;

@Table(name = "Comfort")
@Entity
public class Comfort {

    @Id
    @Column(name = "id")
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "type")
    private ComfortType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ComfortType getType() {
        return type;
    }

    public void setType(ComfortType type) {
        this.type = type;
    }
}
