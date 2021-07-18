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

        System.out.println("\n\n" +
        "          _____  _____              _____ _______       _____ _______ ______ _____  \n" +
        "    /\\   |  __ \\|  __ \\            / ____|__   __|/\\   |  __ \\__   __|  ____|  __ \\ \n" +
        "   /  \\  | |__) | |__) |  ______  | (___    | |  /  \\  | |__) | | |  | |__  | |  | |\n" +
        "  / /\\ \\ |  ___/|  ___/  |______|  \\___ \\   | | / /\\ \\ |  _  /  | |  |  __| | |  | |\n" +
        " / ____ \\| |    | |                ____) |  | |/ ____ \\| | \\ \\  | |  | |____| |__| |\n" +
        "/_/    \\_\\_|    |_|               |_____/   |_/_/    \\_\\_|  \\_\\ |_|  |______|_____/ \n");
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
