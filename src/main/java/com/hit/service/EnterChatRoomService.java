package com.hit.service;

import java.util.ArrayList;

import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;
import com.hit.dm.ChatRoom;
import com.hit.dm.Messages;
import com.hit.dm.User;
import com.hit.server.Request;
import com.hit.server.Response;
import com.mysql.cj.xdevapi.DbDocImpl;
import com.hit.server.Request.*;

public class EnterChatRoomService implements Services {

    private DbHandle dbHandle;
    private Response response;
    private ArrayList<Messages> messageList;
    private User user;
    private ChatRoom chatRoom;

    public EnterChatRoomService() {
        this.response = new Response(new Header("chat_room_page"), new Body());
        this.dbHandle = DbHandleImpl.getInstance();
        this.messageList = new ArrayList<>();
    }

    @Override
    public Response executeService(Request request) {
        response.getBody().setUser(request.getBody().getUser());
        chatRoom = dbHandle.getChatRoomById(request.getBody().getChatRoom().getChatRoom_id());
        response.getBody().setChatRoom(chatRoom);
        messageList = dbHandle.getChatRoomMessages(request.getBody().getChatRoom().getChatRoom_id());
        response.getBody().setMessageList(messageList);
        return response;   
        
    }
    
}
