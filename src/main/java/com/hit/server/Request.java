package com.hit.server;

import java.util.ArrayList;

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
        private ArrayList<User> userList;
        private ArrayList<Game> gameList;
        private String pattern;
        
        public Body() {
            this.userList = new ArrayList<>();
            this.gameList = new ArrayList<>();
            this.pattern = "";
        }
        public Body(ArrayList<User> userList, ArrayList<Game> gameList) {
            this.userList = userList;
            this.gameList = gameList;
            this.pattern = "";
        }

        public Body(ArrayList<User> userList, ArrayList<Game> gameList, String pattern) {
            this.userList = userList;
            this.gameList = gameList;
            this.pattern = pattern;
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
            return "Body [gameList=" + gameList + ", pattern=" + pattern + ", userList=" + userList + "]";
        }
        
    }
}
