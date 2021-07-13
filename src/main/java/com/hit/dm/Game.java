package com.hit.dm;

import java.util.Arrays;

public class Game {
    private int id;
    private String name;
    private byte[] imageBlob;
    private String category;
    private String image;
    
    public Game(int id, String name, byte[] imageBlob, String category) {
        this.id = id;
        this.name = name;
        this.image = "";
        this.imageBlob = imageBlob;
        this.category = category;
    }

    public Game(int id, String name, String image, String category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String catagory) {
        this.category = catagory;
    }

    public byte[] getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(byte[] imageBlob) {
        this.imageBlob = imageBlob;
    }

    @Override
    public String toString() {
        return "Game [category=" + category + ", id=" + id + ", image=" + image + ", imageBlob="
                + Arrays.toString(imageBlob) + ", name=" + name + "]";
    }
    
}
