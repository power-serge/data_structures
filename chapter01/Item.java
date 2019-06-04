package chapter01;

public class Item {
	private String itemName;
	private int value;

	public Item(String name, int value) {
		this.setItemName(name);
		this.value = value;
		
		// TODO Auto-generated constructor stub
	}

	public int getPrice() {
		// TODO Auto-generated method stub
		return this.value;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
