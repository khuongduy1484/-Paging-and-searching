package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "employess")
public class Employess {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String yearold;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "office_id")
    private Office office;

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public Employess(){

    }

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

    public String getYearold() {
        return yearold;
    }

    public void setYearold(String yearold) {
        this.yearold = yearold;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
