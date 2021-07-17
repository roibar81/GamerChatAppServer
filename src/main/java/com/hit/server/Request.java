package com.hit.server;

import java.util.ArrayList;

import com.hit.dm.ChatRoom;
import com.hit.dm.Game;
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
        private Game game;
        private ChatRoom chatRoom;
        private ArrayList<User> userList;
        private ArrayList<Game> gameList;
        private ArrayList<ChatRoom> chatList;
        private String pattern;
        
        public Body() {
            this.userList = new ArrayList<>();
            this.gameList = new ArrayList<>();
            this.chatList = new ArrayList<>();
            this.pattern = "";
        }
      
        public Body(ArrayList<User> userList, ArrayList<Game> gameList, ArrayList<ChatRoom> chatList, String pattern) {
            this.userList = userList;
            this.gameList = gameList;
            this.chatList = chatList;
            this.pattern = pattern;
        }

        public Body(User user, ArrayList<User> userList, ArrayList<Game> gameList, ArrayList<ChatRoom> chatList, String pattern) {
            this.user = user;
            this.userList = userList;
            this.gameList = gameList;
            this.chatList = chatList;
            this.pattern = pattern;
        }
        
        public Body(User user, Game game, ChatRoom chatRoom, ArrayList<User> userList, ArrayList<Game> gameList,
                ArrayList<ChatRoom> chatList, String pattern) {
            this.user = user;
            this.game = game;
            this.chatRoom = chatRoom;
            this.userList = userList;
            this.gameList = gameList;
            this.chatList = chatList;
            this.pattern = pattern;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
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

        public ArrayList<User> getUserList() {
            return userList;
        }

        public void setUserList(ArrayList<User> userList) {
            this.userList = userList;
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

        public String getPattern() {
            return pattern;
        }

        public void setPattern(String pattern) {
            this.pattern = pattern;
        }

        @Override
        public String toString() {
            return "Body [chatList=" + chatList + ", chatRoom=" + chatRoom + ", game=" + game + ", gameList=" + gameList
                    + ", pattern=" + pattern + ", user=" + user + ", userList=" + userList + "]";
        }

    }
}
