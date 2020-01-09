package Account;

import java.util.ArrayList;
import java.util.Scanner;

import Person.Employee;
import Product.Accessory;
import Product.Ukulele;

public class Account {
	public static ArrayList<Account> listAccount = new ArrayList<>();
	private static int countId = 1;
	private String username;
	private String password;
	private int idEmployee;
	private int id=countId;
	//them tai khoan admin sau hien tai fix 3 cai
	public Account(String username, String password){
		countId++;
		this.username=username;
		this.password=password;
		
	}
	public Account(String username, String password,int idEmployee){
		this.username=username;
		this.password=password;
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
	public void setIdEmployee(int idEmployee) {
		this.idEmployee=idEmployee;
	}
	public int getIdEmployee() {
		return idEmployee;
	}
	public int getId() {
		return id;
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
	public static boolean checkRegister(String username,String password1,String password2,int idEmployee) {
		int i;
		for(i=0; i<listAccount.size(); i++) {
			if ((username.equals(listAccount.get(i).getUsername()))) {
					return false;
			}
		}
		if(!password1.equals(password2)) {
			return false;
		}else if(Employee.getIndexOneEmployee(idEmployee)==-1){
			return false;
		}
		return true;
	}
	public String toString() {
		return "Username: "+getUsername()+"\nPassword: "+getPassword();
	}
	public static void fixAccount() {
		listAccount.add(new Account("admin","admin",1));
		listAccount.add(new Account("loan","loan",2));
		listAccount.add(new Account("hung","hung",3));	
	}
	public static void displayAllAccount() {
		for (int i=0; i<listAccount.size();i++) {
			System.out.println(listAccount.get(i));
		}
	}
}
