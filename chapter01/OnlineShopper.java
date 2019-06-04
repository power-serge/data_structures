package chapter01;

import chapter02.ArrayBag;

/** A class that maintains a shopping cart for an online store. */
public class OnlineShopper {
	public static void main(String[] args) {
		Item[] items = { new Item("Bird feeder", 2050),
				new Item("Squirrel guard", 1547),
				new Item("Bird bath", 4499),
				new Item("Sunflower seeds", 1295) };

		@SuppressWarnings("rawtypes")
		BagInterface<Item> shoppingCart = new Bag<ArrayBag>();

		int totalCost = 0;

		// Statements that add selected items to the shopping cart:
		for (int index = 0; index < items.length; index++) {
			Item nextItem = items[index]; // Simulate getting item from shopper
			shoppingCart.add(nextItem);
			totalCost = totalCost + nextItem.getPrice();
		} // end for

		// Simulate checkout
		while (!shoppingCart.isEmpty())
			System.out.println(shoppingCart.remove());
		
		System.out.println("Total cost: " + "\t$" + totalCost / 100 + "." + totalCost % 100);
	} // end main
} // end OnlineShopper
