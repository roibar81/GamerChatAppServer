package com.hit.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.hit.service.RegisterService;
import com.hit.service.Services;
import com.hit.service.SignInService;
import com.google.gson.Gson;

public class HandleRequest implements Runnable {

    private Socket socket;
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
            System.out.println(request);
            action = request.getHeader().getAction();

            switch(action) {
                case "sign_in":
                    services = new SignInService();
                    break;
                case "sign_out":
                    break;
                case "sign_up":
                    services = new RegisterService();
                    break;
                default:
                    break;
            }
            response = services.executeService(request);
            resStr = writeResponse(response);
            System.out.println(resStr);
            writer.writeObject(resStr);
            writer.flush();
        }catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
        
    }
    
    public String writeResponse(Response response) {
        String resStr = null;
        Gson gson = new Gson();
        resStr = gson.toJson(response);
        return resStr;
    }

    public Request readRequest(String requestString) {
        Gson gson = new Gson();
        Request request = gson.fromJson(requestString, Request.class);
        return request;
    }


}
