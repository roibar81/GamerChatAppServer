package com.hit.dao;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

import com.google.protobuf.Message;
import com.hit.dm.*;


public interface DbHandle {
    
    public Connection getConnection();
    //game functions
    public void addGame(Game game);
    public ArrayList<Game> getAllGames();
    public void deleteGame(Game game);
    //friend functions
    public ArrayList<User> getUserFriends(User user);
    public ArrayList<Friend> getAllFriends(User user);
    public void sendFriendRequest(int user_id, int friend_id);
    public void approveFriendRequest(int user_id, int friend_id);
    public boolean isUserFriend(User user,User friend);
    public void deleteUserFriend(User user, User friend);
    //user functions
    public void addUser(User user);
    public ArrayList<User> getAllUsers();
    public void deleteUser(User user);
    public User getUserByName(String username);
    public boolean verifyPassword(User user);
    public boolean isUserExist(User user);
    //chat_rooms
    public ArrayList<ChatRoom> getAllChatRooms();
    public void addChatRoom(ChatRoom chatRoom);
    public void deleteChatRoom(ChatRoom chatRoom);
    public ChatRoom getChatRoomById(int chatRoomId);
    //messages
    public ArrayList<Messages> getAllMessages();
    public void addMessage(Messages messages);
    public void deleteMessage(Messages messages);
    public ArrayList<Messages> getChatRoomMessages(int chat_room_id);

}
