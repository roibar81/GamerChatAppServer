package com.hit.server;

import java.util.ArrayList;

import com.hit.dm.ChatRoom;
import com.hit.dm.Game;
import com.hit.dm.Messages;
import com.hit.dm.User;

public class Request {
    
    private Header header;
    private Body body;

    

    public Request(Header header, Body body) {
        this.header = header;
        this.body = body;
    }

    
    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Request [body=" + body + ", header=" + header + "]";
    }


    public static class Header {
        private String action;

        public Header() {
            this.action = "";
        }

        public Header(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        @Override
        public String toString() {
            return "Header [action=" + action + "]";
        }

    }

    public static class Body {
        private User user;
        private User friend;
        private Game game;
        private ChatRoom chatRoom;
        private Messages message;
        private ArrayList<User> userList;
        private ArrayList<Game> gameList;
        private ArrayList<ChatRoom> chatList;
        private ArrayList<Messages> messageList;
        private ArrayList<User> usersRs;
        private String pattern;
        
        public Body() {
            this.userList = new ArrayList<>();
            this.gameList = new ArrayList<>();
            this.chatList = new ArrayList<>();
            this.usersRs = new ArrayList<>();
            this.pattern = "";
        }
      
        public Body(String pattern) {
            this.userList = new ArrayList<>();
            this.gameList = new ArrayList<>();
            this.chatList = new ArrayList<>();
            this.usersRs = new ArrayList<>();
            this.pattern = pattern;
        }

        public Body(User user, String pattern) {
            this.user = user;
            this.userList = new ArrayList<>();
            this.gameList = new ArrayList<>();
            this.chatList = new ArrayList<>();
            this.usersRs = new ArrayList<>();
            this.pattern = pattern;
        }
        
        public Body(User user, Game game, ChatRoom chatRoom, String pattern) {
            this.user = user;
            this.game = game;
            this.chatRoom = chatRoom;
            this.userList = new ArrayList<>();
            this.gameList = new ArrayList<>();
            this.chatList = new ArrayList<>();
            this.usersRs = new ArrayList<>();
            this.pattern = pattern;
        }
        
        public Body(User user, Game game, ChatRoom chatRoom, Messages message, String pattern) {
            this.user = user;
            this.game = game;
            this.chatRoom = chatRoom;
            this.message = message;
            this.userList = new ArrayList<>();
            this.gameList = new ArrayList<>();
            this.chatList = new ArrayList<>();
            this.messageList = new ArrayList<>();
            this.usersRs = new ArrayList<>();
            this.pattern = pattern;
        }

        public Body(User user, User friend, Game game, ChatRoom chatRoom, Messages message, String pattern) {
            this.user = user;
            this.friend = friend;
            this.game = game;
            this.chatRoom = chatRoom;
            this.message = message;
            this.userList = new ArrayList<>();
            this.gameList = new ArrayList<>();
            this.chatList = new ArrayList<>();
            this.messageList = new ArrayList<>();
            this.usersRs = new ArrayList<>();
            this.pattern = pattern;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
        
        public User getFriend() {
            return friend;
        }

        public void setFriend(User friend) {
            this.friend = friend;
        }

        public Game getGame() {
            return game;
        }

        public void setGame(Game game) {
            this.game = game;
        }

        public ChatRoom getChatRoom() {
            return chatRoom;
        }

        public void setChatRoom(ChatRoom chatRoom) {
            this.chatRoom = chatRoom;
        }
        
        public Messages getMessage() {
            return message;
        }

        public void setMessage(Messages message) {
            this.message = message;
        }

        public ArrayList<User> getUserList() {
            return userList;
        }

        public void setUserList(ArrayList<User> userList) {
            this.userList = userList;
        }
        
        public ArrayList<User> getUsersRs() {
            return usersRs;
        }

        public void setUsersRs(ArrayList<User> usersRs) {
            this.usersRs = usersRs;
        }

        public ArrayList<Game> getGameList() {
            return gameList;
        }
        
        public ArrayList<ChatRoom> getChatList() {
            return chatList;
        }

        public void setChatList(ArrayList<ChatRoom> chatList) {
            this.chatList = chatList;
        }

        public void setGameList(ArrayList<Game> gameList) {
            this.gameList = gameList;
        }

        public ArrayList<Messages> getMessageList() {
            return messageList;
        }

        public void setMessageList(ArrayList<Messages> messageList) {
            this.messageList = messageList;
        }

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        @Override
        public String toString() {
            return "Body [chatList=" + chatList + ", chatRoom=" + chatRoom + ", friend=" + friend + ", game=" + game
                    + ", gameList=" + gameList + ", message=" + message + ", messageList=" + messageList + ", pattern="
                    + pattern + ", user=" + user + ", userList=" + userList + ", usersRs=" + usersRs + "]";
        }

    }
}
