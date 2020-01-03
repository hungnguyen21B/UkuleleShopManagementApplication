package Product;

import java.util.Scanner;

public class Ukulele extends Instrument{

	public Ukulele(String name, double price, String color, int quantity) {
		super(name, price, color, quantity);
		setProfit(1.5);
	}
	public void setProfit(double profit) {
		if(profit>=1.5) {
		this.profit=profit;
		}
		else {
		this.profit=1.5;
		}
	}
	public void setPriceOut(double priceOut) {
		this.priceOut=this.price+this.price*profit;
	}
	public static void editProduct(Ukulele accessory, int idEdit) {
		for (int i=0; i<instrucmentList.size();i++) {
			if (instrucmentList.get(i).getId()==idEdit) {
				instrucmentList.get(i).setColor(accessory.getColor());
				instrucmentList.get(i).setName(accessory.getName());
				instrucmentList.get(i).setPrice(accessory.getPrice());
				instrucmentList.get(i).setQuantity(accessory.getQuantity());
			}
		}
	}
	public static void addProduct(Ukulele accessory) {
		instrucmentList.add(accessory);
	}
}
