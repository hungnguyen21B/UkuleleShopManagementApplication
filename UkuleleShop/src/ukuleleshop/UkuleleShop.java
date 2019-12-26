/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ukuleleshop;

import java.util.ArrayList;
import java.util.Scanner;
import model.Account;

/**
 *
 * @author hung.nguyen
 */
public class UkuleleShop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Account> listAccount = new ArrayList<Account>();
        // TODO code application logic here
        Account a2 = new Account("hung", "hung","231312",true);
        Account a1 = new Account("a", "a","231312");
        listAccount.add(a1);
        listAccount.add(a2);
        String password;
        String username;
        do{
            System.out.println("Login form");
            System.out.println("Enter username:");
            username = input.nextLine();
            System.out.println("Enter password:");
            password = input.nextLine();
            
        }
       while(listAccount.get(0).checkLogin(listAccount,username,password)==false);
    //check
       if (listAccount.get(0).checkRole(listAccount,username)){
           //admin
           System.out.println("Ad");
       }else {
          //user 
          System.out.println("User");
       };
//        System.out.println(listAccount.get(0).getPassword());
//         System.out.println(listAccount.get(1).getPassword());
//          System.out.println(listAccount.get(0).getId());
//         System.out.println(listAccount.get(1).getId());
    }
    
}
