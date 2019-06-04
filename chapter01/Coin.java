package chapter01;

public class Coin {
	private String CoinName;
	private int value;
	private int year;
	private String bank;
	private int quantity;

	public Coin(int quantity, int year, String bank) {
		this.year = year;
		this.bank = bank;
		this.quantity = quantity;
	}

	public Coin(String name, int value) {
		this.CoinName = name;
		this.value = value;
	}

	public Coin(int quantity, int year) {
		this.quantity = quantity;
		this.year = year;
	}
	
	public String getCoinName() {
		return CoinName;
	}

	public void setCoinName(String coinName) {
		CoinName = coinName;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
