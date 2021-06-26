package com.hit.driver;

import java.util.ArrayList;
import com.hit.Password_utils.Password_utils;
import com.hit.dao.DbHandle;
import com.hit.dao.DbHandleImpl;
import com.hit.dm.Game;
import com.hit.server.*;

/**
 * Hello world!
 *
 */
public class App 
{
    static ArrayList<Game> gamesList = new ArrayList<Game>();
    public static void main( String[] args )
    {
        Server server = new Server(12345);
        Password_utils password_utils = Password_utils.getInstance();
        System.out.println( "Hello World!" );
        String salt = password_utils.getSalt(8);
        if(password_utils.validPassword("Aaaaa1234-")) {
            System.out.println("pass ok");
        }
        else
            System.out.println("pass not ok");

        String secpass = password_utils.generateSecurePassword("Aaaaa1234-", salt);
        System.out.println(secpass);
        DbHandle dbHandle = DbHandleImpl.getInstance();
        Game game = new Game(0, "lior", "bla", "action");
        try {
            dbHandle.addGame(game);
            gamesList = dbHandle.getAllGames();
            System.out.println("first:");
            for(Game g : gamesList) {
                System.out.println(g);
            }
            gamesList.remove(0);
            dbHandle.deleteGame(game);
            gamesList = dbHandle.getAllGames();
            System.out.println("second:");
            for(Game g : gamesList) {
                System.out.println(g);
            }
    }catch(Exception e) {
        System.out.println(e.getMessage());
    }
    }
}
