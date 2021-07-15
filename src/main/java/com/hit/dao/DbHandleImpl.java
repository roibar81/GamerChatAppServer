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
import com.hit.dm.*;


public class DbHandleImpl implements DbHandle {

    private Connection conn = null;
	private Statement state = null;
	private ResultSet rs = null;	
	private PreparedStatement prepStat = null;
	private DbQueries queries;
	private static DbHandleImpl instance;
	private Password_utils passUtil; 
    private ArrayList<Friend> friendsList; 
    private Game game;
    private User userTemp;
	private ChatRoom chatRoom;
	private Messages messages;
    private Dbconf dbconf;
	private String secPass;
	private Friend friend;
	private String salt;
	
	private DbHandleImpl() {
		this.passUtil = Password_utils.getInstance();
		this.friendsList = new ArrayList<>();
		this.queries = DbQueries.getInstance();
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
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.out.println(e.getMessage());
		} 
		return conn;
	}

    @Override
    public void addGame(Game game) {
        try {
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.addGame); 
			prepStat.setString(1, game.getName());
			prepStat.setInt(2, game.getImage());
			prepStat.setString(3, game.getCategory());
			prepStat.executeUpdate();
			prepStat.close();
			conn.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
    }

    @Override
    public ArrayList<Game> getAllGames() {
		ArrayList<Game> gamesList = new ArrayList<>();
        try {
			conn= getConnection();
			state = conn.createStatement();
			rs = state.executeQuery(queries.getAllGames);
            while(rs.next()) {
                game = new Game(rs.getString("name"), rs.getInt("image"), rs.getString("category"));
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
    public ArrayList<Friend> getAllFriends(User user) {
        try {
			conn= getConnection();
			state = conn.createStatement();
			rs = state.executeQuery(queries.getAllFriends);
            while(rs.next()) {
                friend = new Friend(rs.getInt("idUser"), rs.getInt("idFriend"));
                friendsList.add(friend);
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return friendsList;
    }

	@Override
	public ArrayList<User> getUserFriends(User user) {
		ArrayList<User> userList;
		userList = getAllUsers();
		for(User u : userList) {
			if(!isUserFriend(user, u) || !isUserFriend(u, user)) {
				userList.remove(u);
			}
		}
		return userList;
	}
	
    @Override
    public boolean isUserFriend(User user, User friend) {
		try {
			conn= getConnection();
			prepStat = conn.prepareStatement(queries.isUserFriend);
            prepStat.setInt(1, user.getId());
			prepStat.setInt(2, friend.getId());
            rs = prepStat.executeQuery();
            while(rs.next()) {
                return true;
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return false;
    }

    @Override
    public void deleteUserFriend(User user, User friend) {
        
        
    }

    @Override
    public void addUser(User user) {
        try {
			salt = passUtil.getSalt(16);
			secPass = passUtil.generateSecurePassword(user.getPassword(), salt);
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.addUser); 
			prepStat.setString(1, user.getName());
			prepStat.setString(2, user.getEmail());
			prepStat.setString(3, secPass);
            prepStat.setString(4, salt);
			prepStat.executeUpdate();
			prepStat.close();
			conn.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<>();    
		try {
			conn= getConnection();
			state = conn.createStatement();
			rs = state.executeQuery(queries.getAllUsers); 
            while(rs.next()) {
                userTemp = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("salt"));
                userList.add(userTemp);
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return userList;
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

	@Override
	public User getUserByName(String username) {
		try {
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.getUserByName); 
			prepStat.setString(1, username);
			rs = prepStat.executeQuery();
            while(rs.next()) {
                userTemp = new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("salt"));
            }		
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}

		return userTemp;
	}

	@Override
	public boolean isUserExist(User user) {
	
		try {
			conn = getConnection();
			userTemp = getUserByName(user.getName());
			if(userTemp.isNameEqual(user))
				return true;	
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return false;
	}
    
	@Override
	public boolean verifyPassword(User user) {
		try {
			conn = getConnection();
			userTemp = getUserByName(user.getName());
			secPass = passUtil.generateSecurePassword(user.getPassword(), userTemp.getSalt());
			prepStat = conn.prepareStatement(queries.verifyPassword);
			prepStat.setString(1, secPass);
			rs = prepStat.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return false;
	}

	@Override
	public ArrayList<ChatRoom> getAllChatRooms() {
		ArrayList<ChatRoom> chatRooms = new ArrayList<>();
		try {
			conn= getConnection();
			state = conn.createStatement();
			rs = state.executeQuery(queries.getAllChatRooms); 
            while(rs.next()) {
                chatRoom = new ChatRoom(rs.getInt("chat_room_id"), rs.getString("name"));
                chatRooms.add(chatRoom);
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return chatRooms;
	}

	@Override
	public void addChatRoom(ChatRoom chatRoom) {
		try {
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.addChatRoom); 
			prepStat.setString(1, chatRoom.getName());
			prepStat.executeUpdate();
			prepStat.close();
			conn.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
	}

	@Override
	public void deleteChatRoom(ChatRoom chatRoom) {
		try {
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.deleteChatRoom); 
			prepStat.setInt(1, chatRoom.getChatRoom_id());
			prepStat.executeUpdate();
			prepStat.close();
			conn.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
	}

	@Override
	public ArrayList<Messages> getAllMessages() {
		ArrayList<Messages> messagesList = new ArrayList<>();
		try {
			conn= getConnection();
			state = conn.createStatement();
			rs = state.executeQuery(queries.getAllMessages); 
            while(rs.next()) {
                messages = new Messages(rs.getInt("message_id"), rs.getInt("chat_room_id"), 
				rs.getString("user_name"), rs.getString("message"), rs.getString("created_at"));
                messagesList.add(messages);
            }
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
		return messagesList;
	}

	@Override
	public void addMessage(Messages messages) {
		try {
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.addMessage); 
			prepStat.setInt(1, messages.getChat_room_id());
			prepStat.setString(2, messages.getUser_name());
			prepStat.setString(3, messages.getMessage());
			prepStat.executeUpdate();
			prepStat.close();
			conn.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
	}

	@Override
	public void deleteMessage(Messages messages) {
		try {
			conn = getConnection();
			prepStat = conn.prepareStatement(queries.deleteMessage); 
			prepStat.setInt(1, messages.getMessage_id());
			prepStat.executeUpdate();
			prepStat.close();
			conn.close();			
		} catch (Exception e) {
			System.out.println(e.getMessage());	
		}
	}

}
