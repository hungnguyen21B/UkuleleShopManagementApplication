/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author hung.nguyen
 */
public class Account  implements IAccount{
    private static int countid=0;
    private int id;
    private String username;
    private String password;
    private String phone;
    private boolean role=false;

    public Account(String username, String password,String phone, boolean role){
        countid+=1;
        this.id=countid;
        this.username=username;
        this.password=password;
        this.phone=phone;
        this.role=role;
    }
    public Account(String username, String password,String phone){
        countid+=1;
        this.id=countid;
        this.username=username;
        this.password=password;
        this.phone=phone;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the role
     * 
     * 
     */
    public boolean isRole(){
        
        return role;
    }

    public boolean checkRole(ArrayList<Account> listAccount,String username){
         for(int i=0;i<listAccount.size();i++){
            if(listAccount.get(i).getUsername().equals(username) ){
                return listAccount.get(i).isRole();
            }
        }
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(boolean role) {
        this.role = role;
    }
    public boolean checkLogin(ArrayList<Account> listAccount,String username, String password){
        for(int i=0;i<listAccount.size();i++){
            if(listAccount.get(i).getUsername().equals(username) && listAccount.get(i).getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
    public boolean checkRegister(ArrayList<Account> listAccount,String username, String password1,String password2){
        for(int i=0;i<listAccount.size();i++){
            if(listAccount.get(i).getUsername().equals(username)){
                return false;
            }
        }
        if(password1!=password2){
            return false;
        }
        return true;
    }
    
    
}
