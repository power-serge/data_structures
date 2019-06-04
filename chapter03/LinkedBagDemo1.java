package chapter03;

import chapter01.BagInterface;

/**
 * A test of the methods add, toArray, isEmpty, and getCurrentSize, as defined
 * in the first draft of the class LinkedBag.
 */
public class LinkedBagDemo1 {
	public static void main(String[] args) {
		System.out.println("Creating an empty bag.");
		BagInterface<String> aBag = new LinkedBag<>();
		testIsEmpty(aBag, true);
		displayBag(aBag);
		String[] contentsOfBag = { "A", "D", "B", "A", "C", "A", "D" };
		testAdd(aBag, contentsOfBag);
		testIsEmpty(aBag, false);
		testRemove(aBag, contentsOfBag);
	} // end main

	private static void testRemove(BagInterface<String> aBag, String[] tests) {
		for (int index = 0; index < tests.length; index++) {
			String aString = tests[index];
			if (aString.equals("") || (aString == null)) {
				// test remove()
				System.out.println("\nRemoving a string from the bag:");
				String removedString = aBag.remove();
				System.out.println("remove() returns " + removedString);
			} else {
				// test remove(aString)
				System.out.println("\nRemoving \"" + aString + "\" from the bag:");
				boolean result = aBag.remove(aString);
				System.out.println("remove(\"" + aString + "\") returns " + result);
			} // end if

			displayBag(aBag);
		} // end for
	} // end testRemove
//Tests the method isEmpty.
//Precondition: If bag is empty, the parameter empty should be true;
//otherwise, it should be false.

	private static void testIsEmpty(BagInterface<String> bag, boolean empty) {
		System.out.print("\nTesting isEmpty with ");
		if (empty)
			System.out.println("an empty bag:");
		else
			System.out.println("a bag that is not empty:");
		System.out.print("isEmpty finds the bag ");
		if (empty && bag.isEmpty())
			System.out.println("empty: OK.");
		else if (empty)
			System.out.println("not empty, but it is: ERROR.");
		else if (!empty && bag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");
	}// end testIsEmpty

//Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content) {
		System.out.print("Adding the following strings to the bag: ");
		for (int index = 0; index < content.length; index++) {
			if (aBag.add(content[index]))
				System.out.print(content[index] + " ");
			else
				System.out.print("\nUnable to add " + content[index] + " to the bag.");
		} // end for
		System.out.println();
		displayBag(aBag);
	} // end testAdd

//Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag contains the following string(s):");
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++) {
			System.out.print(bagArray[index] + " ");
		} // end for
		System.out.println();
	} // end displayBag
} // end LinkedBagDemo1