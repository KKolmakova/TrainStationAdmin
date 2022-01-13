package com.kolmakova.dto;

import com.kolmakova.types.DocumentType;

public class DocumentDTO {

    private Integer id;
    private DocumentType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DocumentType getType() {
        return type;
    }

    public void setType(DocumentType type) {
        this.type = type;
    }
}
