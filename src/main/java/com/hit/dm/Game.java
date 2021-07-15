package com.hit.dm;

import java.util.Arrays;

public class Game {
    private String name;
    private String category;
    private int image;
    

    public Game(String name, int image, String category) {
        this.name = name;
        this.image = image;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String catagory) {
        this.category = catagory;
    }

    @Override
    public String toString() {
        return "Game [category=" + category + ", image=" + image + ", name=" + name + "]";
    }

}
