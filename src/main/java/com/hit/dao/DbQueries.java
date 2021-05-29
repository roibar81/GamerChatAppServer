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
    public String gallAllGames = "select * from games;";
    public String deleteGame = "delete from games where=?;";
    //user table queries
}
