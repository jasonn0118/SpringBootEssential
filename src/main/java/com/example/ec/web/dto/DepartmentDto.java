package com.example.ec.web.dto;

import com.example.ec.domain.enumeration.Room;

import java.io.Serializable;
import java.time.LocalDate;

public class DepartmentDto implements Serializable {
    private Long id;
    private LocalDate createdDate;
    private String name;
    private Room room;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
