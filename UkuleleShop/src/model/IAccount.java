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
public interface IAccount {
    public boolean checkRole(ArrayList<Account> listAccount,String username);
    public boolean checkLogin(ArrayList<Account> listAccount,String username, String password);
    public boolean checkRegister(ArrayList<Account> listAccount,String username, String password1,String password2);
}
