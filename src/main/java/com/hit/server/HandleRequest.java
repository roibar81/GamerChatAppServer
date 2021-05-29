package com.hit.server;

import java.net.Socket;

public class HandleRequest implements Runnable {

    private Socket socket;

    public HandleRequest(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        
        
    }
    
}
