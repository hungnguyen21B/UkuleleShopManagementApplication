package App;

import java.util.ArrayList;
import java.util.Scanner;

import Account.Account;
import Person.Employee;
import Person.Manager;
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
		String exit=null;
		int idCheckLogin=-1;
		//neu check = -1 la khong co tai khoan
		do {
		System.out.println("\nEnter (113) to exit another key to countinue. ");
		exit=input.next();
		if (!exit.equals("113")) {
			System.out.println("\nEnter username: ");
			username=input.next();
			System.out.println("\nEnter password: ");
			password=input.next();
		}else {
			pageMain();
		}	
			idCheckLogin=Account.checkLogin(username, password);
		}while(idCheckLogin==-1);
		try {
			Manager check=(Manager) Employee.employeeList.get(Account.listAccount.get(idCheckLogin).getIdEmployee());
			formAdmin(Account.listAccount.get(idCheckLogin).getIdEmployee());
		}catch(Exception e){
			formEmployee(Account.listAccount.get(idCheckLogin).getIdEmployee());
		}
	}
	public void formAdmin(int id) {
		System.out.println("****************************************");
		System.out.println("*             MANAGER                  *");
		System.out.println("****************************************");
		System.out.println("\n");
		System.out.printf("\t1.Manage employee \t2.Manage product");
		int choose;
		do {
			System.out.println("\nChoose: ");
			choose=input.nextInt();
		}while(choose<1 && choose>2);
		switch(choose) {
		case 2: {
			//fix id cua manager la 0 employee la con lai
			formEmployee(id);
			break;
		}
		case 1: {
			//fix id cua manager la 0 employee la con lai
			formManageEmployeeOfManager(id);
			break;
		}
	}
}
	public void formManageEmployeeOfManager(int id) {
		System.out.println("****************************************");
		System.out.println("*             MANNAGER                 *");
		System.out.println("****************************************");
		System.out.println("\n");
		System.out.printf("\t1.Edit employee \t2.Delete employee \t3.Add employee");
		System.out.println("\t4.View a employee \t5.View all of employee");
		int choose;
		do {
			System.out.println("\nChoose: ");
			choose=input.nextInt();
		}while(choose<1 && choose>5);
		Manager man =(Manager) Employee.employeeList.get(Employee.getIndexOneEmployee(id));//dang ra la get tai 0 la idEmp tai account 
		switch(choose) {
		case 1: {
			//fix id cua manager la 0 employee la con lai
			man.editEmployee();
			break;
		}
		case 2: {
			//fix id cua manager la 0 employee la con lai
			man.deleteEmployee();
			break;
		}
		case 3: {
			//fix id cua manager la 0 employee la con lai
			man.addEmployee();
			break;
		}
		case 4: {
			//fix id cua manager la 0 employee la con lai
			man.viewOneEmployee();;
			break;
		}
		case 5: {
			//fix id cua manager la 0 employee la con lai
			man.viewAllEmployee();
			break;
		}
		}
		
	}; 
	public void formEmployee(int id) {
		System.out.println("****************************************");
		System.out.println("*             EMPLOYEE                 *");
		System.out.println("****************************************");
		System.out.println("\n");
		System.out.printf("\t1.Edit product \t2.Delete product \t3.Add product");
		int choose;
		do {
			System.out.println("\nChoose: ");
			choose=input.nextInt();
		}while(choose<1 && choose>3);
		Employee emp = Employee.employeeList.get(Employee.getIndexOneEmployee(id));
		switch(choose) {
		case 1: {
			//fix id cua manager la 0 employee la con lai
			emp.editProduct();//so 2 la id cua mot employee
			break;
		}
		case 2: {
			//fix id cua manager la 0 employee la con lai
			emp.deleteProduct();//so 2 la id cua mot employee
			break;
		}
		case 3: {
			//fix id cua manager la 0 employee la con lai
			emp.addProduct();//so 2 la id cua mot employee
			break;
		}
		}
	}
	public void registerForm() {
		System.out.println("****************************************");
		System.out.println("*             REGISTER                 *");
		System.out.println("****************************************");
		System.out.println("\n");
		String username= null;
		String password1 = null;
		int id= 0;
		String password2 = null;
		String exit=null;
		//neu check = -1 la khong co tai khoan
		do {
		System.out.println("\nEnter (113) to exit another key to countinue. ");
		exit=input.next();
		if (!exit.equals("113")) {
			System.out.println("\nEnter your id employee: ");
			id=input.nextInt();
			System.out.println("\nEnter username: ");
			username=input.next();
			System.out.println("\nEnter password: ");
			password1=input.next();
			System.out.println("\nConfirm: ");
			password2=input.next();
		}else {
			pageMain();
		}
//		System.out.println(Account.checkRegister(username, password1,password2));
		}while(!Account.checkRegister(username, password1,password2,id));
		Account acc = new Account(username,password1,id);
		Account.listAccount.add(acc);
		//add a account to list
		System.out.println("\nSuccessful...");
		loginForm();
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
	public static void fixData() {
		Account.fixAccount();
		Instrument.fixProduct();
		Employee.fixAccount();
		
	}
	public static void main(String[] args) {
//		fixData();
//		System.out.println( Instrument.instrucmentList.get(1).toString());
		UkuleleShopApplication app = new UkuleleShopApplication();
		app.runApp();

	}

}
