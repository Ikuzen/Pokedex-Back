package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "Pokemon")
@Entity
public
class Pokemon {

    private @Id @GeneratedValue Long id;
    private String name;
    private float height;
    private float weight;

    @Embedded
    @OneToMany(
            mappedBy = "types",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name="types")
    private Types types;

    @Embedded
    @OneToMany(
            mappedBy = "abilities",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="abilities")

    private Abilities abilities;

    @Embedded
    @OneToMany(
            mappedBy = "images",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="images")

    private Images images;

    @Embedded
    @OneToMany(
            mappedBy = "stats",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="stats")

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

    Pokemon(){}

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