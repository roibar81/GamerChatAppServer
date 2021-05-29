package com.hit.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.hit.dm.Game;


public interface DbHandle {
    public Connection getConnection();
    public void addGame(Game game);
    public ArrayList<Game> getAllGames();
    public void deleteGame(Game game);
}
