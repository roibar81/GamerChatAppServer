package com.hit.service;

import java.util.ArrayList;

import com.hit.algorithm.IAlgoStringMatching;
import com.hit.dm.User;
import com.hit.field_util.UserField;
import com.hit.server.Request;
import com.hit.server.Request.*;
import com.hit.server.Response;

public class SearchUserService implements Services{
    private IAlgoStringMatching iAlgoStringMatching;
    private UserField userField;
    private Response response;
    private ArrayList<User> userList; 

    public SearchUserService(IAlgoStringMatching iAlgoStringMatching, UserField userField) {
        this.iAlgoStringMatching = iAlgoStringMatching;
        this.userField = userField;
        this.response = new Response(new Header("search-user-by-name-success"), new Body());
        this.userList = new ArrayList<>();
    }

    @Override
    public Response executeService(Request request) {
        for(int i=0; i<request.getBody().getUserList().size(); i++) {

            if(request.getBody().getPattern().equals("")){
                userList = request.getBody().getUserList();
            }
            else if(iAlgoStringMatching.searchStringMatching(request.getBody().getPattern(),
             userField.getUserField(request.getBody().getUserList().get(i)))) {
                userList.add(request.getBody().getUserList().get(i));
            }
        }
        response.getBody().setUser(request.getBody().getUser());
        response.getBody().setUserList(request.getBody().getUserList());
        response.getBody().setUsersRs(userList);
        return response;
    }

    
    
}
