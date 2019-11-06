package com.chupin.model;

import javax.persistence.*;

@MappedSuperclass
public abstract class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("id"))
    long id;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
