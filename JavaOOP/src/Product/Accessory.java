package Product;

import java.util.Scanner;

public class Accessory extends Instrument{
		
		public Accessory(String name, double price, String color, int quantity) {
			super(name, price, color, quantity);
//			setProfit(1);
			setPriceOut(price);
		}
		public void setProfit(double profit) {
			if(profit<=1.5 && profit>=1) {
			this.profit=profit;
			}
			else {
			this.profit=1;
			}
		}
		public void setPriceOut(double priceOut) {
//			System.out.print(priceOut);
			this.priceOut=priceOut+priceOut*profit;
		}
		
		public static void editProduct(Accessory accessory, int idEdit) {
			for (int i=0; i<instrucmentList.size();i++) {
				if (instrucmentList.get(i).getId()==idEdit) {
					instrucmentList.get(i).setColor(accessory.getColor());
					instrucmentList.get(i).setName(accessory.getName());
					instrucmentList.get(i).setPrice(accessory.getPrice());
					instrucmentList.get(i).setQuantity(accessory.getQuantity());
				}
			}
		}
		public static void addProduct(Accessory accessory) {
			instrucmentList.add(accessory);
		}
		
		
	}


