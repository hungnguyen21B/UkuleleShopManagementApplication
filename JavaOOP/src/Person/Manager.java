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
	public void editEmployee() {
		try {
		displayAllEmployee();
		System.out.println("Enter the code you want to edit: ");
		int idEdit = input.nextInt();
		System.out.println("Enter name: ");
		String name = input.next();
		System.out.println("Enter address: ");
		String address = input.next();
		System.out.println("Enter phonenumber: ");
		String phonenumber = input.next();
		System.out.println("Enter the salary: ");
		float salary = input.nextFloat();
		System.out.println("Enter the gender: ");
		boolean gender = input.nextBoolean();
		System.out.println("Enter the age: ");
		int age = input.nextInt();
		for (int i=0; i<employeeList.size();i++) {
			if (employeeList.get(i).getId()==idEdit) {
				employeeList.get(i).setName(name);
				employeeList.get(i).setAddress(address);
				employeeList.get(i).setPhonenumber(phonenumber);
				employeeList.get(i).setSalary(salary );
				employeeList.get(i).setGender(gender);
				employeeList.get(i).setAge(age);
			}
		}
		displayOneEmployee(idEdit);
		}
		catch(Exception e) {
			System.out.println("Fill true information.");
			editEmployee();
		}
	}
	public void addEmployee() {
		try {
			int newid=Employee.countId+1;
			System.out.println("The new employee's id is: "+newid);
			int choose=0;
			do {
				System.out.println("Enter the type(1=employee)(2=manager): ");
				choose = input.nextInt();
			}while(choose<1 && choose>2);
			System.out.println("Enter name: ");
			String name = input.next();
			System.out.println("Enter address: ");
			String address = input.next();
			System.out.println("Enter phonenumber: ");
			String phonenumber = input.next();
			System.out.println("Enter the salary: ");
			float salary = input.nextFloat();
			System.out.println("Enter the gender: ");
			boolean gender = input.nextBoolean();
			System.out.println("Enter the age: ");
			int age = input.nextInt();
			if(choose==1) {
			employeeList.add(new Employee(name,address,phonenumber,salary,gender,age));
			}
			else {
			employeeList.add(new Manager(name,address,phonenumber,salary,gender,age));
			}
			}
		catch(Exception e) {
			System.out.println("Fill true information.");
			addEmployee();
		}
		}
	public  void deleteEmployee() {
		try {
			System.out.println("Enter the employee's id you want to delete: ");
			int idChoose = input.nextInt();
				employeeList.remove(Employee.getIndexOneEmployee(idChoose));
			}
		catch(Exception e) {
			System.out.println("Make sure the id already exists.");
			deleteEmployee();
		}
		}
		
}
