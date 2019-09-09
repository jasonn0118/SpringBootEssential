package com.example.ec.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.example.ec.domain.enumeration.Room;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="created_date")
    private LocalDate createdDate;
    @Column(name="name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name="room")
    private Room room;

    @OneToMany(mappedBy = "department")
    @Cache(usage= CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PastorDepartment> pastorDepartments = new HashSet<>();

    protected Department() {
    }

    public Department(Long id,LocalDate createdDate, String name,Room room) {
        this.id = id;
        this.createdDate = createdDate;
        this.name = name;
        this.room = room;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }
    public Department createdDate(LocalDate createdDate){
        this.createdDate = createdDate;
        return this;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public String getName() {
        return name;
    }

    public Department name(String name){
        this.name = name;
        return this;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }
    public Department room(Room room){
        this.room = room;
        return this;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
    //
//    public Set<PastorDepartment> getPastorDepartments() {
//        return pastorDepartments;
//    }
//    public Department pastorDepartments(Set<PastorDepartment> pastorDepartments){
//        this.pastorDepartments = pastorDepartments;
//        return this;
//    }
//    public Department addPastorDepartment(PastorDepartment pastorDepartment){
//        this.pastorDepartments.add(pastorDepartment);
//        pastorDepartment.setDepartment(this);
//        return this;
//    }
//    public Department removePastorDepartment(PastorDepartment pastorDepartment){
//        this.pastorDepartments.remove(pastorDepartment);
//        pastorDepartment.setDepartment(null);
//        return this;
//    }
//
//    public void setPastorDepartments(Set<PastorDepartment> pastorDepartments) {
//        this.pastorDepartments = pastorDepartments;
//    }
}
