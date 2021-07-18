package com.hit.service;

import java.util.ArrayList;
import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;
import com.hit.dm.User;
import com.hit.server.Request;
import com.hit.server.Response;
import com.hit.server.Request.*;

public class GetFriendsService implements Services {

    private DbHandle dbHandle;
    private Response response;
    
    public GetFriendsService() {
        this.dbHandle = DbHandleImpl.getInstance();
        this.response = new Response(new Header("get_friends"), new Body());
    }
    @Override
    public Response executeService(Request request) {
        ArrayList<User> friendList = dbHandle.getUserFriends(request.getBody().getUser());
        response.getBody().setUser(request.getBody().getUser());
        response.getBody().setUserList(friendList);
        return null;
    }
    
}
