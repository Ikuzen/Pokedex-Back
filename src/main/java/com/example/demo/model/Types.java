package com.example.demo.model;



import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class Types {
    private String[] types;

    public Types(String ... types) {
        this.types = types;
    }
    Types(){}
}