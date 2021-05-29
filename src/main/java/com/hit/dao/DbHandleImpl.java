package com.hit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.hit.Password_utils.Password_utils;
import com.hit.dm.Game;


public class DbHandleImpl implements DbHandle {

    private Connection conn = null;
	private Statement state = null;
	private ResultSet rs = null;	
	private PreparedStatement prepStat = null;
	private DbQueries queries = DbQueries.getInstance();
	private static DbHandleImpl instance;
	private Password_utils passUtil = Password_utils.getInstance();
    private ArrayList<Game> gamesList = null;
	
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
		String path = "jdbc:mysql://localhost:3306/gamerChatApp";
		String user = "root";
		String pass = "Kill-Z0ne";
		try {
		    // create a connection to the db
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		    conn = DriverManager.getConnection(path, user, pass);   
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
        // TODO Auto-generated method stub
        
    }

    @Override
    public ArrayList<Game> getAllGames() {
        try {
			conn= getConnection();
			state = conn.createStatement();
			rs = state.executeQuery(queries.getAllGames);
            while(rs.next()) {
                
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return null;
    }

    @Override
    public void deleteGame(Game game) {
        // TODO Auto-generated method stub
        
    }


    
}
