package com.example.demo.model;



import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="types")
public class Types {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    private String[] types;

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public Types(String ... types) {
        this.types = types;
    }
    Types(){}
}