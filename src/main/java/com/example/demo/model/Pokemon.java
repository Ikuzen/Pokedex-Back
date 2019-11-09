package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Table(name = "pokemons")
@Entity
public class Pokemon {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) @Column(name="id") Long id;
    private int number;
    private String name;
    private float height;
    private float weight;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "types_id", referencedColumnName = "id")
    private Types types;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "abilities_id", referencedColumnName = "id")
    private Abilities abilities;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "images_id", referencedColumnName = "id")
    private Images images;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stats_id", referencedColumnName = "id")
    private Stats stats;


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