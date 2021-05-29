package com.hit.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.hit.Password_utils.Password_utils;
import com.hit.dm.Dbconf;
import com.hit.dm.Game;
import com.hit.dm.User;


public class DbHandleImpl implements DbHandle {

    private Connection conn = null;
	private Statement state = null;
	private ResultSet rs = null;	
	private PreparedStatement prepStat = null;
	private DbQueries queries = DbQueries.getInstance();
	private static DbHandleImpl instance;
	private Password_utils passUtil = Password_utils.getInstance();
    private ArrayList<Game> gamesList = new ArrayList<Game>();
    private ArrayList<User> friendsList = new ArrayList<User>();
    private Game game;
    private User user;
    private Dbconf dbconf;
	
	private DbHandleImpl() {
		
	}
	
	public static DbHandle getInstance() {
    	if(instance == null) {
    		instance = new DbHandleImpl();
    	}
    	return instance;
    }
    
    @Override
	public Connection getConnection(){ //Getting connection to db
        dbconf = getDbconf();

		try {
		    // create a connection to the db
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    conn = DriverManager.getConnection(dbconf.getPath(), dbconf.getUser(), dbconf.getPass());   
		} catch(SQLException e) {
		   System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return conn;
	}

    @Override
    public void addGame(Game game) {
        try {
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.addGame); 
			prepStat.setInt(1, game.getId());
			prepStat.setString(2, game.getName());
			prepStat.setString(3, game.getImage());
			prepStat.setString(4, game.getCatagory());
			prepStat.executeUpdate();
			prepStat.close();
			conn.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
    }

    @Override
    public ArrayList<Game> getAllGames() {
        try {
			conn= getConnection();
			state = conn.createStatement();
			rs = state.executeQuery(queries.getAllGames);
            while(rs.next()) {
                game = new Game(rs.getInt("id"), rs.getString("name"), rs.getString("image"), rs.getString("category"));
                gamesList.add(game);
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return gamesList;
    }

    @Override
    public void deleteGame(Game game) {
        try {
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.deleteGame); 
			prepStat.setString(1, game.getName());
			prepStat.executeUpdate();
			prepStat.close();
			conn.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
    }

    @Override
    public ArrayList<User> getUserFriends(User user) {
        try {
			conn= getConnection();
			prepStat = conn.prepareStatement(queries.getUserFriends);
            prepStat.setInt(1, user.getId());
            rs = prepStat.executeQuery();
            while(rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("salt"));
                friendsList.add(user);
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return friendsList;
    }

    @Override
    public void addUserFriend(User user, User friend) {
 
    }

    @Override
    public void deleteUserFriend(User user, User friend) {
        
        
    }

    @Override
    public void addUser(User user) {
        try {
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.addUser); 
			prepStat.setInt(1, user.getId());
			prepStat.setString(2, user.getName());
			prepStat.setString(3, user.getEmail());
			prepStat.setString(4, user.getPassword());
            prepStat.setString(5, user.getSalt());
			prepStat.executeUpdate();
			prepStat.close();
			conn.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
    }

    @Override
    public ArrayList<User> getAllUsers() {
            try {
			conn= getConnection();
			state = conn.createStatement();
			rs = state.executeQuery(queries.getAllGames);  //rs contain the query result.
            while(rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("salt"));
                friendsList.add(user);
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return friendsList;
    }

    @Override
    public void deleteUser(User user) {
        try {
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.deleteUser); 
			prepStat.setString(1, user.getName());
			prepStat.executeUpdate();
			prepStat.close();
			conn.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
    }

    private Dbconf getDbconf() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("src/resources/dbconf.json")) {
			dbconf = gson.fromJson(reader, Dbconf.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return dbconf;
    }
    
}
