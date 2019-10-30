package com.example.demo.model;


import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable

public class Images {
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
