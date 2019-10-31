package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="abilities")
public class Abilities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;


    private String[] abilities;

    public Abilities(String ... abilities) {
        this.abilities = abilities;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public void setAbilities(String[] abilities) {
        this.abilities = abilities;
    }


    Abilities(){}
}