package com.hit.service;

import java.util.ArrayList;
import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;
import com.hit.dm.User;
import com.hit.server.Request;
import com.hit.server.Response;
import com.hit.server.Request.*;

public class SendFriendRequestService implements Services {

    private DbHandle dbHandle;
    private Response response;

    public SendFriendRequestService() {
        this.dbHandle = DbHandleImpl.getInstance();
        response = new Response(new Header("send_friend_request_success"), new Body());
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
