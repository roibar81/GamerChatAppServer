package com.hit.dm;

public class Dbconf {
    private String path;
    private String user;
    private String pass;
    
    public Dbconf(String path, String user, String pass) {
        this.path = path;
        this.user = user;
        this.pass = pass;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Dbconf [pass=" + pass + ", path=" + path + ", user=" + user + "]";
    }
    
}
