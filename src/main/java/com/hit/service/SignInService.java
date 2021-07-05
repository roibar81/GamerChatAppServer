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
    
    public SignInService() {
        this.dbHandle = DbHandleImpl.getInstance();
        this.userList = new ArrayList<>();
    }

    @Override
    public Response executeService(Request request) {
        response = new Response(request.getHeader(), new Body());
        user = request.getBody().getUserList().get(0);
        if(dbHandle.isUserExist(user) && dbHandle.verifyPassword(user)) {
            response.getHeader().setAction("sign_in success");
            user = dbHandle.getUserByName(user.getName());
            userList.add(user);
            response.getBody().setUserList(this.userList);

        }
        else 
            response.getHeader().setAction("sign_in faild");
        return response;
    }

}
