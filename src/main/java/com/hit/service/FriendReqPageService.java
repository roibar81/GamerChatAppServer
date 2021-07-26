package com.hit.service;

import java.util.ArrayList;

import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;
import com.hit.dm.User;
import com.hit.server.Request;
import com.hit.server.Request.*;
import com.hit.server.Response;

public class FriendReqPageService implements Services{

    private DbHandle dbHandle;
    private Response response;
    private ArrayList<User> userList;

    public FriendReqPageService() {
        this.dbHandle = DbHandleImpl.getInstance();
        this.response = new Response(new Header("friend-list-page"), new Body());
        this.userList = new ArrayList<>();
    }

    @Override
    public Response executeService(Request request) {
        for(int i=0; i<request.getBody().getUserList().size(); i++) {
            if(dbHandle.isUserFriend(request.getBody().getUserList().get(i), request.getBody().getUser()) && 
            !dbHandle.isUserFriend(request.getBody().getUser(),request.getBody().getUserList().get(i) )) {
                userList.add(request.getBody().getUserList().get(i));
            }
        }
        response.getBody().setUser(request.getBody().getUser());
        response.getBody().setUserList(userList);
        return response;
    }
    
}
