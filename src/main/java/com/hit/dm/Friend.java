package com.hit.dm;

public class Friend {
    private int idUser;
    private int idFriend;
    
    public Friend(int idUser, int idFriend) {
        this.idUser = idUser;
        this.idFriend = idFriend;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdFriend() {
        return idFriend;
    }

    public void setIdFriend(int idFriend) {
        this.idFriend = idFriend;
    }

    @Override
    public String toString() {
        return "Friend [idFriend=" + idFriend + ", idUser=" + idUser + "]";
    }

}
