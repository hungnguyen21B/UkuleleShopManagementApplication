package Person;

import java.util.ArrayList;
import java.util.Scanner;
import Product.Accessory;
import Product.Instrument;
import Product.Ukulele;

public class Employee implements IEmployee {
	public static ArrayList<Employee> employeeList = new ArrayList<>();
	protected static int countId = 1;
	protected int id=countId;
	protected String name;
	protected String address;
	protected String phonenumber;
	protected float salary;
	protected boolean gender;//true is male
	protected int age;
	Scanner input = new Scanner(System.in);
	public Employee() {
		
	}
	public Employee(String name, String address, String phonenumber, float salary, boolean gender, int age) {
		countId++;
		this.name=name;
		this.address=address;
		this.phonenumber=phonenumber;
		this.salary=salary;
		this.gender=gender;
		this.age=age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber=phonenumber;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
	public int getId() {
		return id;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender=gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setSalary(float salary) {
		this.salary=salary;
	}
	public float getSalary() {
		return salary;
	}
	public void viewOneProduct() {
		System.out.println("Enter the code you want to view: ");
		int idChoose = input.nextInt();
		Instrument.displayOneProduct(idChoose);
	}
	public void viewAllProduct() {
		Instrument.displayAllProduct();
	};
	public void editProduct() {
		System.out.println("Enter the code you want to edit: ");
		int idChoose = input.nextInt();
		System.out.println("Product: ");
		Instrument.displayOneProduct(idChoose);
		
	};
	public void addProduct() {
		try {
		int idChoose;
		do {
		System.out.println("Enter the type(1=ukulele)(2=accesory): ");
		idChoose = input.nextInt();
		}while(idChoose<1 && idChoose>2);
		System.out.println("Enter the name: ");
		String name = input.next();
		System.out.println("Enter the color: ");
		String color = input.next();
		System.out.println("Enter the price: ");
		double price = input.nextDouble();
		System.out.println("Enter the quantity: ");
		int quantity = input.nextInt();
		if(idChoose==1) {
		Ukulele.addProduct(new Ukulele(name,price,color,quantity));	
		}else {
		Accessory.addProduct(new Accessory(name,price,color,quantity));	
		}}
		catch(Exception e) {
			addProduct();
		}
	}
	public void deleteProduct() {
		System.out.println("Enter the code you want to delete: ");
		int idChoose = input.nextInt();
		Instrument.deleteProduct(idChoose);
	}
	public static void fixAccount() {
		employeeList.add(new Manager("hung","qb","123",10f,true,15));
		employeeList.add(new Employee("hung","qb","1223",120f,true,12));
		employeeList.add(new Employee("hung","bd","1123",120f,false,13));
		employeeList.add(new Employee("loan","qt","1123",130f,true,50));
		employeeList.add(new Employee("hung","qb","123",130f,true,10));
		
	}
	public static void displayAllEmployee() {
		for (int i=0; i<employeeList.size();i++) {
			System.out.println(employeeList.get(i));
		}
	}
	public static int getIndexOneEmployee(int id) {
		for (int i=0; i<employeeList.size();i++) {
			if(employeeList.get(i).getId()==id) {
				return i;
			}
		}
		return -1;
	}
	public static void displayOneEmployee(int id) {
		for (int i=0; i<employeeList.size();i++) {
			if(employeeList.get(i).getId()==id) {
				System.out.println(employeeList.get(i));
			}
		}
	}
	public String toString(){
		return "Id: "+getId()+"\nName:"+getName()+"\nAddess:"+getAddress()
		+"\nPhonenumber:"+getPhonenumber()+"\nSalary:"+getSalary()+"\nGender:"+gender
		+"\nAge:"+getAge();
		}
}
