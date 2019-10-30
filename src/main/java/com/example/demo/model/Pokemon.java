package com.example.demo.model;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Pokemon {

    private @Id @GeneratedValue Long id;
    private String name;
    private float height;
    private float weight;


    @Embedded
    private Types types;

    @Embedded
    private Abilities abilities;

    @Embedded
    private Images images;

    @Embedded
    private Stats stats;

    public Pokemon(String name, Types types, float height, float weight, Abilities abilities, Images images, Stats stats) {
        this.name = name;
        this.types = types;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.images = images;
        this.stats = stats;
    }

    Pokemon() {}


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

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }
}