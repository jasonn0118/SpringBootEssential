package com.example.ec.web.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class PastorDto implements Serializable {
    private Long id;
    private LocalDate createdDate;
    private Integer personId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
