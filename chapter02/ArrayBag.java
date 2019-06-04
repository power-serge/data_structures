package chapter02;

import chapter01.BagInterface;

/**
 * A class of bags whose entries are stored in a fixed-size array. INITIAL,
 * INCOMPLETE DEFINITION; no security checks
 */
public final class ArrayBag<T> implements BagInterface<T> {

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;
	private boolean integrityOK = false;
	private static final int MAX_CAPACITY = 10000;

	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	} // end default constructor


//	public ArrayBag(int desiredCapacity) {
//		// The cast is safe because the new array contains null entries.
//		@SuppressWarnings("unchecked")
//		T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
//		bag = tempBag;
//		numberOfEntries = 0;
//	} // end constructor
	
	
	/**
	 * Creates an empty bag having a given initial capacity. *
	 * 
	 * @paramdesiredCapacity The integer capacity desired.
	 */
	public ArrayBag(int desiredCapacity) {
		if (desiredCapacity <= MAX_CAPACITY) { // The cast is safe because the new array contains null entries
			@SuppressWarnings("unchecked")
			T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
			bag = tempBag;
			numberOfEntries = 0;
			integrityOK = true;
		} else
			throw new IllegalStateException("Attempt to create a bag whose capacity exceeds allowed maximum.");
	} // end
	

	// Throws an exception if this object is not initialized.
	private void checkIntegrity() {
		if (!integrityOK)
			throw new SecurityException("ArrayBag object is corrupt.");
	} // end checkIntegrity
	

//	public boolean add(T newEntry) {
//		boolean result = true;
//		if (isArrayFull()) {
//			result = false;
//		} else { // Assertion: result is true here
//			bag[numberOfEntries] = newEntry;// numberOfEntries++;
//		} // end if
//		return result;
//
//	} // end add
	

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean add(T newEntry) {
		checkIntegrity();
		boolean result = true;
		if (isArrayFull()) {
			result = false;
		} else { // Assertion: result is true here
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
		} // end if
		return result;
	}

	/**
	 * Retrieves all entries that are in this bag. *
	 * 
	 * @returnA newly allocated array of all the entries in this bag.
	 */
	public T[] toArray() { // The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		} // end for
		return result;
	} // end toArray

	// Returns true if this bag is full, or false if not.
	private boolean isArrayFull() {
		return numberOfEntries >= bag.length;
	} // end isArrayFull

	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return (numberOfEntries == 0);
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry The entry to be counted.
	 * @return The number of times anEntry appears in this bag.
	 */
	public int getFrequencyOf(T anEntry) {
		checkIntegrity();
		int counter = 0;

		for (int index = 0; index < numberOfEntries; index++) {
			if (anEntry.equals(bag[index])) {
				counter++;
			} // end if
		}
		return counter;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}
} // end ArrayBag
