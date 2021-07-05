package com.hit.service;

import java.util.ArrayList;

import com.hit.Password_utils.Password_utils;
import com.hit.dao.*;
import com.hit.dm.User;
import com.hit.server.Request;
import com.hit.server.Response;
import com.hit.server.Request.Body;

public class RegisterService implements Services{

    private DbHandle dbHandle;
    private Password_utils password_utils;
    private User user;
    private Response response;
    private ArrayList<User> userList;
    
    public RegisterService() {
        this.dbHandle = DbHandleImpl.getInstance();
        this.password_utils = Password_utils.getInstance();
        this.userList = new ArrayList<>();
    }

    @Override
    public Response executeService(Request request) {
        response = new Response(request.getHeader(), new Body());
        user = request.getBody().getUserList().get(0);
        User userTemp = new User(dbHandle.generateUserId(), user.getName(), 
        user.getEmail(), user.getPassword(), password_utils.getSalt(16));
        if(password_utils.validPassword(user.getPassword()) && !dbHandle.isUserExist(user)) {
            response.getHeader().setAction("sign_up success");
            dbHandle.addUser(userTemp);
            userList.add(userTemp);
            response.getBody().setUserList(userList);
        }
        else {
            response.getHeader().setAction("sign_up faild");
        }
        return response;
    }
    
}
