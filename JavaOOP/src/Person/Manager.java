package Person;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Manager extends Employee implements IManager{
	Scanner input = new Scanner(System.in);
	public static boolean isManager=true;
public Manager() {
		
	}
	public Manager(String name, String address, String phonenumber, float salary, boolean gender, int age) {
		super(name, address, phonenumber, salary, gender, age);
	}
	public  void viewOneEmployee() {
		System.out.println("\nEnter ID of a employee: ");
		int choose=input.nextInt();
		try {
           Employee.displayOneEmployee(choose);
        } catch (Exception e) {
        	viewOneEmployee();
        }
	}
	public  void viewAllEmployee() {
		Employee.displayAllEmployee();
	}
	public  void editEmployee() {
		System.out.println("\nEnter ID of a employee: ");
	}
	public void addEmployee() {
		
	}
	public  void deleteEmployee() {
	
	}
	
}
