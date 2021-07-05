package com.hit.service;

import java.util.ArrayList;
import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;
import com.hit.dm.User;
import com.hit.server.Request;
import com.hit.server.Response;
import com.hit.server.Request.Body;

public class AddFriendService implements Services {

    private ArrayList<User> userList;
    private DbHandle dbHandle;
    private Response response;

    public AddFriendService() {
        this.userList = new ArrayList<>();
        this.dbHandle = DbHandleImpl.getInstance();
    }

    @Override
    public Response executeService(Request request) {
        response = new Response(request.getHeader(), new Body());
        
        return response;
    }
    
}
