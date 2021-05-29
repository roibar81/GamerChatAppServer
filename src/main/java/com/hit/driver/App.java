package com.hit.driver;

import com.hit.Password_utils.Password_utils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
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
    }
}
