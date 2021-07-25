package com.hit.driver;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.hit.server.*;

public class App 
{
   
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
