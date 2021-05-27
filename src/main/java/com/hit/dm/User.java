package com.hit.dm;

import java.util.List;

public class User {
    private String name;
    private String email;
    private String salt;
    private String password;
    private List<User> friends;
    private List<Games> favGames;
    
    public User(String name, String email, String password, List<User> friends, List<Games> favGames) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.friends = friends;
        this.favGames = favGames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Games> getFavGames() {
        return favGames;
    }

    public void setFavGames(List<Games> favGames) {
        this.favGames = favGames;
    }

    @Override
    public String toString() {
        return "User [email=" + email + ", favGames=" + favGames + ", friends=" + friends + ", name=" + name
                + ", password=" + password + ", salt=" + salt + "]";
    }

    
}
