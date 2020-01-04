package Product;

import java.util.ArrayList;

public abstract class Instrument implements IProduct {
	public static ArrayList<Instrument> instrucmentList = new ArrayList<>();
	private static int countId = 0;
	private int id=countId;
	protected String name;
	protected double price;
	protected double profit;
	protected double priceOut;
	protected String color;
	protected double oldPrice;
	protected int quantity;
	
	public static void fixProduct() {
		instrucmentList.add(new Ukulele("u1",10,"black",5));
		instrucmentList.add(new Ukulele("u2",5,"blue",5));
		instrucmentList.add(new Ukulele("u3",15,"black",15));
		instrucmentList.add(new Ukulele("u4",20,"green",5));
		instrucmentList.add(new Ukulele("u5",11,"black",10));
		instrucmentList.add(new Accessory("a1",10,"black",5));
		instrucmentList.add(new Accessory("a2",5,"blue",5));
		instrucmentList.add(new Accessory("a3",15,"black",15));
		instrucmentList.add(new Accessory("a4",20,"green",5));
		instrucmentList.add(new Accessory("a5",11,"black",10));
		
	}
	public Instrument(String name,double price,String color,int quantity) {
		countId++;
		this.name=name;
		this.color=color;
		this.price=price;
		this.quantity=quantity;
		setPriceOut(price);
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	protected void setOldPrice(double oldPrice) {
		this.oldPrice=oldPrice;
	};
	public double getOldPrice() {
		return oldPrice;
	}
	public double getProfit() {
		return profit;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}
	public void setPrice(double price) {
		this.price=price;
	};
	public void setPriceOut(double priceOut) {
//		System.out.print(priceOut);
		this.priceOut=priceOut+priceOut;
	}
	public double getPrice() {
		return price;
	}
	
	public double getPriceOut() {
		return priceOut;
	}
	public String toString(){
		return "Id: "+getId()+" Name:"+getName()
		+" \nPrice: "+getPrice()+" Old Price:"+getOldPrice()
		+" \nProfit: "+getProfit()+" Price Out:"+getPriceOut()
		+" \nColor: "+getColor()+" Quantity:"+getQuantity();
	}
	public static void deleteProduct(int id) {
		for (int i=0; i<instrucmentList.size();i++) {
			if (instrucmentList.get(i).getId()==id) {
				instrucmentList.remove(i);
			}
		}
	}
	public static void displayAllProduct() {
		for (int i=0; i<instrucmentList.size();i++) {
			System.out.println(instrucmentList.get(i));
		}
	}
	public static void displayOneProduct(int id) {
			System.out.println(instrucmentList.get(id).getName());
		
	}
	

}
