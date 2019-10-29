package com.example.demo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
class Pokemon {

    private @Id @GeneratedValue Long id;
    private String name;
    private String[] types;
    private int height;
    private int weight;
    private Object moves;
    private String images;
    private int[] stats;

    public Pokemon(Long id, String name, String[] types, int height, int weight, Object moves, String images, int[] stats) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.height = height;
        this.weight = weight;
        this.moves = moves;
        this.images = images;
        this.stats = stats;
    }

    Pokemon() {}

    Pokemon(String name, String[] types, int height, int weight, Object moves, String images, int[] stats) {
        this.name = name;
        this.types = types;
    }
}