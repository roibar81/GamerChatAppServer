package com.hit.driver;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.hit.dm.Game;
import com.hit.dm.User;
import com.hit.server.*;

public class App 
{
    static ArrayList<Game> gamesList = new ArrayList<>();
    static ArrayList<User> userList = new ArrayList<>();
    
    public static void main( String[] args )
    {
        try{
            ExecutorService executorService = Executors.newFixedThreadPool(100);
            Server server = new Server(12345);
    
            // executorService.execute(server);
            // Password_utils password_utils = Password_utils.getInstance();
            // String salt =  password_utils.getSalt(16);
            // //User user = new User(0, "or", "orjslash27@gmail.com", password_utils.generateSecurePassword("Aaaaa-1234", salt), salt);
            // DbHandle dbHandle = DbHandleImpl.getInstance();
        
            // //dbHandle.addUser(user);
            // //dbHandle.deleteUser(user);
            // userList = dbHandle.getAllUsers();
            // for(User u : userList) {
            //     System.out.println(u);
            // }
        }catch(Exception e) {
            e.printStackTrace();
        }
        // System.out.println( "Hello World!" );
        // String salt = password_utils.getSalt(8);
        // if(password_utils.validPassword("Aaaaa1234-")) {
        //     System.out.println("pass ok");
        // }
        // else
        //     System.out.println("pass not ok");

        // String secpass = password_utils.generateSecurePassword("Aaaaa1234-", salt);
        // System.out.println(secpass);
        // DbHandle dbHandle = DbHandleImpl.getInstance();
        // Game game = new Game(0, "lior", "bla", "action");
        // try {
        //     dbHandle.addGame(game);
        //     gamesList = dbHandle.getAllGames();
        //     System.out.println("first:");
        //     for(Game g : gamesList) {
        //         System.out.println(g);
        //     }
        //     gamesList.remove(0);
        //     dbHandle.deleteGame(game);
        //     gamesList = dbHandle.getAllGames();
        //     System.out.println("second:");
        //     for(Game g : gamesList) {
        //         System.out.println(g);
        //     }
    // }catch(Exception e) {
    //     System.out.println(e.getMessage());
    // }
    }
}
