package com.hit.dm;

import java.sql.Blob;

public class Game {
    private int id;
    private String name;
    private String catagory;
    private String image;
    private Blob imageBlob;
    
    
    public Game(int id, String name, Blob imageBlob, String catagory) {
        this.id = id;
        this.name = name;
        this.catagory = catagory;
        this.imageBlob = imageBlob;
    }

    public Game(int id, String name, String image, String catagory) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.catagory = catagory;
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

    public String getCatagory() {
        return catagory;
    }

    public void setCatagory(String catagory) {
        this.catagory = catagory;
    }

    
    public Blob getImageBlob() {
        return imageBlob;
    }

    public void setImageBlob(Blob imageBlob) {
        this.imageBlob = imageBlob;
    }

    @Override
    public String toString() {
        return "Game [catagory=" + catagory + ", id=" + id + ", image=" + image + ", imageBlob=" + imageBlob + ", name="
                + name + "]";
    }

}
