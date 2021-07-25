package com.hit.service;

import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;
import com.hit.dm.User;
import com.hit.server.Request;
import com.hit.server.Response;
import com.hit.server.Request.*;

public class ApproveFriendRequestService implements Services{

    private DbHandle dbHandle;
    private Response response;

    public ApproveFriendRequestService() {
        this.dbHandle = DbHandleImpl.getInstance();
        this.response = new Response(new Header("approve_friend_request"), new Body());
    }

    @Override
    public Response executeService(Request request) {
        User friend = dbHandle.getUserByName(request.getBody().getFriend().getName());
        dbHandle.sendFriendRequest(request.getBody().getUser().getId(), friend.getId());
        response.getBody().setUser(request.getBody().getUser());
        response.getBody().setFriend(friend);
        return response;
    }
    
}
