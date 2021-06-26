package com.hit.server;

import java.net.Socket;
import java.util.ArrayList;
import com.hit.dm.Game;
import com.hit.dm.User;

public class HandleRequest implements Runnable {

    private Socket socket;
    private Header Header;
    private Body body;
    private Request request;
    private Response response;
    private ArrayList<User> userList;
    private ArrayList<Game> gameList;
    
    public HandleRequest(Socket socket) {
        this.socket = socket;
        this.userList = new ArrayList<>();
        this.gameList = new ArrayList<>();
    }

    @Override
    public void run() {
        
        
    }
    
}
