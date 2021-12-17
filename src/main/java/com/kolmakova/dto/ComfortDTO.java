package com.kolmakova.dto;

import com.kolmakova.types.ComfortType;

public class ComfortDTO {

    private Integer id;
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

    @Override
    public String toString() {
        return "ComfortDTO{" +
                "id=" + id +
                ", type=" + type +
                '}';
    }
}
