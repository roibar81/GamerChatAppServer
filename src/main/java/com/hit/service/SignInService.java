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
    private ChatRoom chatRoom;
    private Response response;
    private ArrayList<User> userList;
    private ArrayList<Game> gameList;
    private ArrayList<ChatRoom> chatList;

    public SignInService() {
        this.dbHandle = DbHandleImpl.getInstance();
        chatRoom = new ChatRoom();
        this.userList = new ArrayList<>();
        this.gameList = new ArrayList<>();
        this.chatList = new ArrayList<>();
    }

    @Override
    public Response executeService(Request request) {
        response = new Response(request.getHeader(), new Body());
        user = request.getBody().getUser();
        if(dbHandle.isUserExist(user) && dbHandle.verifyPassword(user)) {
            response.getHeader().setAction("sign_in success");
            User userTemp = dbHandle.getUserByName(user.getName());
            response.getBody().setUser(userTemp);
            userList = dbHandle.getAllUsers();
            response.getBody().setUserList(userList);
            gameList = dbHandle.getAllGames();
            response.getBody().setGameList(gameList);
            chatList = dbHandle.getAllChatRooms();
            response.getBody().setChatList(chatList);
            response.getBody().setChatRoom(chatRoom);
        }
        else 
            response.getHeader().setAction("sign_in faild");
        return response;
    }

}
