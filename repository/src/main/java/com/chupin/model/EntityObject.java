package com.chupin.model;

import javax.persistence.*;

@MappedSuperclass
public class EntityObject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = ("id"))
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
