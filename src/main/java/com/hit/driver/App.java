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
    
 
        }catch(Exception e) {
            e.printStackTrace();
        }
    
    }
}
