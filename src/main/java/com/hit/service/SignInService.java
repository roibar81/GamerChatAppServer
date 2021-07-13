package com.hit.service;

import java.util.ArrayList;
import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;
import com.hit.dm.*;
import com.hit.server.*;
import com.hit.server.Request.*;

public class SignInService implements Services{
    
    private DbHandle dbHandle;
    private User user;
    private Response response;
    private ArrayList<User> userList;
    private ArrayList<Game> gameList;

    public SignInService() {
        this.dbHandle = DbHandleImpl.getInstance();
        this.userList = new ArrayList<>();
        this.gameList = new ArrayList<>();
    }

    @Override
    public Response executeService(Request request) {
        response = new Response(request.getHeader(), new Body());
        user = request.getBody().getUserList().get(0);
        if(dbHandle.isUserExist(user) && dbHandle.verifyPassword(user)) {
            response.getHeader().setAction("sign_in success");
            user = dbHandle.getUserByName(user.getName());
            response.getBody().setUser(user);
            userList = dbHandle.getAllUsers();
            response.getBody().setUserList(userList);
            gameList = dbHandle.getAllGames();
            response.getBody().setGameList(gameList);
        }
        else 
            response.getHeader().setAction("sign_in faild");
        return response;
    }

}
