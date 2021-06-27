package com.hit.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable{

    private ServerSocket serverSocket;
    private int port;
    private HandleRequest handleRequest;

    public Server(int port) {
        this.port = port;
        new Thread(this).start();
    }

    
    @Override
    public void run() {
        Socket socket = null;

        System.out.println("Server started");
        try {
            serverSocket = new ServerSocket(this.port);
            ExecutorService executorService = Executors.newFixedThreadPool(20);
            while(true) {
                socket = serverSocket.accept();
                handleRequest = new HandleRequest(socket);
                executorService.execute(handleRequest);  
            }
        } catch (IOException e) {
            System.out.println("Server couldent start" + e);  
        }
        finally {
            try {
                serverSocket.close();
                System.out.println("Server closed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
