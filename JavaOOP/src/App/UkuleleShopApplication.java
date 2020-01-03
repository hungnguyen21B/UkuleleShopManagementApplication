package App;

import java.util.ArrayList;
import java.util.Scanner;

import Account.Account;
import Person.Employee;
import Product.Instrument;


public class UkuleleShopApplication {
	
	Scanner input = new Scanner(System.in);
	public void runApp() {
		fixData();
		pageMain();
		
	}
	public void loginForm() {
		System.out.println("****************************************");
		System.out.println("*               LOGIN                  *");
		System.out.println("****************************************");
		System.out.println("\n");
		String username= null;
		String password = null;
		int exit=0;
		int idCheckLogin=-1;
		//neu check = -1 la khong co tai khoan
		do {
		System.out.println("\nEnter (113) to exit another key to countinue. ");
		exit=input.nextInt();
		if (exit!=113) {
			System.out.println("\nEnter username: ");
			username=input.next();
			System.out.println("\nEnter passwrod: ");
			password=input.next();
		}else {
			pageMain();
		}	
			idCheckLogin=Account.checkLogin(username, password);
		}while(idCheckLogin==-1);
		if(Account.listAccount.get(idCheckLogin).isRole()) {
			formAdmin();
		}else {
			formEmployee();
		}
	}
	public void formAdmin() {
		System.out.println("****************************************");
		System.out.println("*             MANAGER                  *");
		System.out.println("****************************************");
		System.out.println("\n");
	}
	public void formEmployee() {
		System.out.println("****************************************");
		System.out.println("*             EMPLOYEE                  *");
		System.out.println("****************************************");
		System.out.println("\n");
	}
	public void registerForm() {
		System.out.println("****************************************");
		System.out.println("*             REGISTER                  *");
		System.out.println("****************************************");
		System.out.println("\n");
	}
	public void pageMain() {
		System.out.println("*******UKULELE SHOP APPLICATION*********");
		System.out.println("****************************************");
		System.out.println("*          1.LOGIN 2.REGISTER          *");
		System.out.println("****************************************");
		System.out.println("\n");
		int choose=0;
		do {
			System.out.println("\n Choose:");
			choose=input.nextInt();
		}while (choose!=1 && choose!=2);
		switch(choose) {
		case 1:{
			loginForm();
			break;
		}
		case 2:{
			registerForm();
			break;
		}
		}
	}
	public void fixData() {
		Account.fixAccount();
		Instrument.fixProduct();
		Employee.fixAccount();
		
	}
	public static void main(String[] args) {
		UkuleleShopApplication app = new UkuleleShopApplication();
		app.runApp();
//		Employee.fixAccount();
//		Employee.displayAllEmployee();
//		System.out.println("\nadsadsadsadsadsadsad");
//		Instrument.fixProduct();
//		Instrument.displayAllProduct();
//		System.out.println("\nadsadsadsadsadsadsad");
//		Account.fixAccount();
//		Account.displayAllAccount();

	}

}
