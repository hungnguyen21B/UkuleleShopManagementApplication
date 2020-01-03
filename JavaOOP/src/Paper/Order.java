package Paper;

import java.util.ArrayList;
import java.util.Scanner;

import Product.Accessories;
import Product.Instrument;
import Product.Musical_Int;

public class Order {
	static Instrument m = new Musical_Int();
	static Instrument a = new Accessories();
	static ArrayList<Instrument> orderList = new ArrayList<>();
	protected char handlingShipping;

	public void setHandlingShipping(char handlingShipping) {
		this.handlingShipping = handlingShipping;
	}

	public char getHandlingShipping() {
		return handlingShipping;
	}

	public static void fixOrder() {

		m.setColor(Instrument.instrucmentList.get(1).getColor());
		m.setName(Instrument.instrucmentList.get(1).getName());
		m.setPrice(Instrument.instrucmentList.get(1).getPrice());
		m.setQuantity(1);
		orderList.add(m);

		// --------------------------------------------------------

		a.setColor(Instrument.instrucmentList.get(13).getColor());
		a.setName(Instrument.instrucmentList.get(13).getName());
		a.setPrice(Instrument.instrucmentList.get(13).getPrice());
		a.setQuantity(2);
		orderList.add(a);

	}

	public static void addOrder(Instrument instrument) {
		orderList.add(instrument);
	}

	public static void viewOrder() {
		System.out.println(" List Your Order");
		for (Instrument instrument : orderList) {
			System.out.println(instrument);
		}
	}

	public static void order(ArrayList<Instrument> instrucmentList) {

		Scanner input = new Scanner(System.in);
		int id;
		int choose = 0;
		int quantity;
		char method = 0;
		do {

			System.out.println("Enter id of product:");
			id = input.nextInt();
			do {
				System.out.println("Enter quantity:");
				quantity = input.nextInt();
			} while (quantity <= 0);

			System.out.println("Enter handling shipping:");
			System.out.println("Truck(t)   Airplane(a) ");
			method = input.next().charAt(method);

			Instrument add = null;
			for (int i = 0; i < instrucmentList.size(); i++) {
				if (id == instrucmentList.get(i).getId()) {
					if (quantity <= instrucmentList.get(i).getQuantity()) {

						add.setColor(instrucmentList.get(i).getColor());
						add.setName(instrucmentList.get(i).getName());
						add.setPrice(instrucmentList.get(i).getPrice());
						add.setQuantity(quantity);
						addOrder(add);
						break;
					} else
						System.out.println("Out of stock");
					break;

				} else {
					System.out.println("Not found");
					System.out.println("0. Cancel");
					System.out.println("Another number to re-enter");
					choose = input.nextInt();
					if (choose == 0) {
						System.exit(0);
						break;
					} else
						choose = 1;
					;
				}
			}
		} while (choose == 1);
	}
}
