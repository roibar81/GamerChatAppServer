package com.hit.service;

import java.util.ArrayList;
import java.util.Comparator;

import com.hit.Password_utils.Password_utils;
import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;
import com.hit.dm.*;
import com.hit.server.*;
import com.hit.server.Request.*;

public class SignInService implements Services{
    
    private DbHandle dbHandle;
    private Password_utils password_utils;
    private User user;
    private Response response;
    private ArrayList<User> userList;
    private ArrayList<Game> gameList;
    
    public SignInService() {
        this.dbHandle = DbHandleImpl.getInstance();
        this.password_utils = Password_utils.getInstance();
        this.userList = new ArrayList<>();
        this.gameList = new ArrayList<>();
        this.response = new Response(new Header("sign_in_response"), new Body());
    }

    @Override
    public Response executeService(Request request) {
        user = request.getBody().getUserList().get(0);
        if(dbHandle.isUserExist(user) && dbHandle.validUser(user)) {
            response.getBody().setValid(true);
            this.userList.add(request.getBody().getUserList().get(0));
            response.getBody().setUserList(this.userList);

        }
        return response;
    }

}
