package Account;

import java.util.ArrayList;
import java.util.Scanner;

import Product.Accessory;
import Product.Ukulele;

public class Account {
	public static ArrayList<Account> listAccount = new ArrayList<>();
	//private static int[] arrayAd = new int[]{1};
	//quy dinh tai khoan admin co idemploy 1 la admin
	private static int countId = 0;
	private String username;
	private String password;
	private String phonenumber;
	private boolean role=false;// flase is user //true is admin
	private int id=countId;
	//private int idEmployee;
	//them tai khoan admin sau hien tai fix 3 cai
	public Account(String username, String password, String phonenumber){
		countId++;
		this.username=username;
		this.password=password;
		this.phonenumber=phonenumber;
	}
	public Account(String username, String password, String phonenumber,boolean role){
		this.username=username;
		this.password=password;
		this.phonenumber=phonenumber;
		this.role=role;
		countId++;
	}
	
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return password;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber=phonenumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public int getId() {
		return id;
	}
	public void setRole(boolean role) {
		this.role=role;
	}
	public boolean isRole() {
		return role;
	}
	public static int checkLogin(String username,String password) {
		int i;
		for(i=0; i<listAccount.size(); i++) {
			if ((username.equals(listAccount.get(i).getUsername()))&&(password.equals(listAccount.get(i).getPassword()))) {
				return listAccount.get(i).getId();
			}
		}
		//neu -1 la khong co trong mang account
		return -1;
	}
	public static boolean checkRegister(String username,String password1,String password2) {
		int i;
		for(i=0; i<listAccount.size(); i++) {
			if ((username!=listAccount.get(i).getUsername())&&(password1==password2)) {
				return true;
			}
		}
		return false;
	}
	public String toString() {
		return "Username: "+getUsername()+"\nPassword: "+getPassword();
	}
	public static void fixAccount() {
		listAccount.add(new Account("admin","admin","123",true));
		listAccount.add(new Account("loan","loan","113"));
		listAccount.add(new Account("hung","hung","123"));
		
	}

	public static void displayAllAccount() {
		for (int i=0; i<listAccount.size();i++) {
			System.out.println(listAccount.get(i));
		}
	}
}
