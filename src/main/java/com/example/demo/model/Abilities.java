package com.example.demo.model;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable

public class Abilities {

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
