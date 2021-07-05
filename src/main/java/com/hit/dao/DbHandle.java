package com.hit.dao;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.hit.dm.Game;
import com.hit.dm.User;


public interface DbHandle {
    
    public Connection getConnection();
    //game functions
    public void addGame(Game game);
    public ArrayList<Game> getAllGames();
    public void deleteGame(Game game);
    //friend functions
    public ArrayList<User> getUserFriends(User user);
    public void addUserFriend(User user,User friend);
    public void deleteUserFriend(User user, User friend);
    public boolean isUserExist(User user);
    //user functions
    public void addUser(User user);
    public ArrayList<User> getAllUsers();
    public void deleteUser(User user);
    public User getUserByName(String username);
    public boolean verifyPassword(User user);
    public int generateUserId();

}
