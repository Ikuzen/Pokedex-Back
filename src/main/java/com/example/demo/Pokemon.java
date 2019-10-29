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



    private float height;
    private float weight;
    private String[] moves;
    private String images;
    private int[] stats;

    public Pokemon(String name, String[] types, float height, float weight, String[] moves, String images, int[] stats) {
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

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
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

    public String[] getMoves() {
        return moves;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int[] getStats() {
        return stats;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }
}