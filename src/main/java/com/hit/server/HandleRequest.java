package com.hit.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import com.hit.dm.Game;
import com.hit.dm.User;
import com.hit.server.Request.*;
import com.hit.service.Services;
import com.hit.service.SignInService;
import com.google.gson.Gson;

public class HandleRequest implements Runnable {

    private Socket socket;
    private Header header;
    private Body body;
    private Request request;
    private Response response;
    private String action;
    private String reqStr;
    private String resStr;
    private ObjectInputStream reader;
	private ObjectOutputStream writer;
    private Services services;
    
    public HandleRequest(Socket socket) {
        this.socket = socket;
        try {
    		writer = new ObjectOutputStream(this.socket.getOutputStream());
    		reader = new ObjectInputStream(this.socket.getInputStream());
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }

    @Override
    public void run() {

        try {
            reqStr = reader.readObject().toString();
            request = readRequest(reqStr);

            action = request.getHeader().getAction();

            switch(action) {
                case "sign_in":
                    services = new SignInService();
                    break;
                default:
                    break;
            }
            response = services.executeService(request);
            resStr = writeResponse(response);
            writer.writeObject(resStr);
        }catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        
    }
    
    public static String writeResponse(Response response) {
        String resStr = null;
        Gson gson = new Gson();
        resStr = gson.toJson(response);
        return resStr;
    }

    public static Request readRequest(String requestString) {
        Gson gson = new Gson();
        Request request = gson.fromJson(requestString, Request.class);
        return request;
    }

}
