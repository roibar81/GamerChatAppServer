package dao;

import java.util.ArrayList;

import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;
import com.hit.dm.ChatRoom;
import com.hit.dm.Game;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddChatRoomTest {
    
    private DbHandle dbHandle;
    private ChatRoom chatRoom;
    private ArrayList<ChatRoom> chatRoomList;
    private ArrayList<Game> gamesList;

    @Before
    public void beforeTest() {
        dbHandle = DbHandleImpl.getInstance();
        gamesList = dbHandle.getAllGames();
        chatRoomList = new ArrayList<>();
    }

    @Test
    public void test() {
        // for(Game game : gamesList) {
        //     chatRoom = new ChatRoom(game.getName()+" chat", game.getImage());
        //     dbHandle.addChatRoom(chatRoom);
        // }
    }

    @After
    public void afterTest() {
        chatRoomList = dbHandle.getAllChatRooms();
        for(ChatRoom chatRoom : chatRoomList) {
            System.out.println(chatRoom);
        }
    }

}
