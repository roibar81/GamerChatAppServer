package com.hit.dao;

public class DbQueries {
    private static DbQueries instance;

    private DbQueries() {

    }

    public static DbQueries getInstance() {
        if(instance == null) {
            instance = new DbQueries();
        }
        return instance;
    }
    //games table queries
    public String addGame = "insert into games (id, name, image, category)" +
    "values (?, ?, ?, ?);";
    public String getAllGames = "select * from games;";
    public String deleteGame = "delete from games where name=?;";
    //user table queries
    public String addUser = "insert into users (id, name, email, password, salt)" +
    "values (?, ?, ?, ?, ?);";
    public String getAllUsers = "select * from users;";
    public String getUserByName = "select * from users where name=?;";
    public String deleteUser = "delete from users where name=?;";
    public String verifyPassword = "select * from users where password=?;";
    //friend table queries
    public String getAllFriends = "select * from friends;";
    public String addUserFriend = "insert into friends (idUser, idFriend) values (?, ?);";
    public String deleteUserFriend = "delete from friends where idUser=? and idFriend=?;";
    public String isUserFriend = "select * from friends where idUser=? and idFriend=?;";
    public String idUserExist = "select * from friends where idUser=?;";
    public String idFriendExist = "select * from friends where isFriend=?;";
}
