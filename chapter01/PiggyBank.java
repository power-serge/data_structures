package chapter01;

import chapter02.ArrayBag;

/** A class that implements a piggy bank by using a bag. */
public class PiggyBank {
	private BagInterface<Coin> coins;

	public PiggyBank() {
		coins = new ArrayBag<>();
	} // end default constructor

	public boolean add(Coin aCoin) {
		return coins.add(aCoin);
	} // end add

	public Coin remove() {
		return coins.remove();
	} // end remove

	public boolean isEmpty() {
		return coins.isEmpty();
	} // end isEmpty
} // end PiggyBank
