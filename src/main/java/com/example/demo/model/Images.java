package com.example.demo.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="images")
public class Images {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;
    private String smallImage;
    private String largeImage;

    public Images(String smallImage, String largeImage) {
        this.smallImage = smallImage;
        this.largeImage = largeImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public String getLargeImage() {
        return largeImage;
    }

    public void setLargeImage(String largeImage) {
        this.largeImage = largeImage;
    }
    Images(){}
}