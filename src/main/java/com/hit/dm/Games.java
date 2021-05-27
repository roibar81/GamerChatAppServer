package com.hit.dm;

public class Games {
    String name;
    String image;
    String catagory;
    
    public Games(String name, String image, String catagory) {
        this.name = name;
        this.image = image;
        this.catagory = catagory;
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

    @Override
    public String toString() {
        return "Games [catagory=" + catagory + ", image=" + image + ", name=" + name + "]";
    }

    
}
