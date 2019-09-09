package com.example.ec.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="pastor")
public class Pastor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="created_date")
    private LocalDate createdDate;

    @Column(name="person_id")
    private Integer personId;

    @OneToMany(mappedBy = "pastor")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<PastorDepartment> pastorDepartments = new HashSet<>();

    protected Pastor(){

    }
    public Pastor(Long id,LocalDate createdDate, Integer personId) {
        this.id = id;
        this.createdDate = createdDate;
        this.personId = personId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public Pastor createdDate(LocalDate createdDate){
        this.createdDate = createdDate;
        return this;
    }
    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getPersonId() {
        return personId;
    }
    public Pastor personId(Integer personId){
        this.personId = personId;
        return this;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

//    public Set<PastorDepartment> getPastorDepartments() {
//        return pastorDepartments;
//    }
//    public Pastor pastorDepartments(Set<PastorDepartment> pastorDepartments){
//        this.pastorDepartments = pastorDepartments;
//        return this;
//    }
//    public Pastor addPastorDepartment(PastorDepartment pastorDepartment){
//        this.pastorDepartments.add(pastorDepartment);
//        pastorDepartment.setPastor(this);
//        return this;
//    }
//    public Pastor removePastorDepartment(PastorDepartment pastorDepartment){
//        this.pastorDepartments.remove(pastorDepartment);
//        pastorDepartment.setPastor(null);
//        return this;
//    }
//
//    public void setPastorDepartments(Set<PastorDepartment> pastorDepartments) {
//        this.pastorDepartments = pastorDepartments;
//    }
}
