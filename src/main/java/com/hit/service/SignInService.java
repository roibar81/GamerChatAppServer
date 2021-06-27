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
        if(dbHandle.isUserExist(user) && dbHandle.validUser(user)) {
            response.getBody().setValid(true);
            userList.add(request.getBody().getUserList().get(0));
            response.getBody().setUserList(this.userList);

        }
        return response;
    }

}
