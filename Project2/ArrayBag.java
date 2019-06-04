package Project2;

/**
 * @author Yraita_JR_S
 *
 */
public final class ArrayBag<T> implements BagInterface<T> {

	private final T[] bag;
	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 25;

	/** Creates an empty bag whose initial capacity is 25. */
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	} // end default constructor

	/**
	 * Creates an empty bag having a given capacity.
	 * 
	 * @param desiredCapacity The integer capacity desired.
	 */
	@SuppressWarnings("unchecked")
	public ArrayBag(int desiredCapacity) {
		bag = (T[]) new Object[desiredCapacity];
		numberOfEntries = 0;
	} // end constructor

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return numberOfEntries <= 0;
	}

	@Override
	public boolean add(T newEntry) {
		if (numberOfEntries < bag.length) {
			bag[numberOfEntries] = newEntry;
			numberOfEntries++;
			return true;
		}
		return false;
	}

	@Override
	public T remove() {
		if (isEmpty()) {
			return null;
		}
		T buffer = bag[numberOfEntries - 1];
		bag[numberOfEntries - 1] = null;
		numberOfEntries--;
		return buffer;
	}

	@Override
	// Remove the first occurrence of the given object
	public boolean remove(T anEntry) {
		if (this.contains(anEntry)) {
			while (this.contains(anEntry)) {
				for (int i = 0; i < bag.length; i++) {
					if (anEntry == bag[i]) { // found
						bag[i] = bag[numberOfEntries - 1];// copy the last object to the target PO:
						bag[numberOfEntries - 1] = null;
						numberOfEntries--;
					} // end inner if
				} // end for loop/
			} // end while loop
			return true;
		} // end outer if
		return false;
	}// end remove
	
	/*alt remove method from quiz*/
	public boolean rmve(T anEntry) {
		boolean flag = false;
		for (int i = 0; i < numberOfEntries; i++) {
			if (bag[i] == anEntry) {
				numberOfEntries--;
				bag[i] = bag[numberOfEntries];
				bag[numberOfEntries] = null;
				i--;
				flag = true;
			}
		}
		return flag;
	}

	@Override
	public void clear() {
		while (!this.isEmpty()) {
			this.remove();
		}
		numberOfEntries = 0;

	}

	@Override
	public int getFrequencyOf(T anEntry) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < numberOfEntries; i++) {
			if (bag[i] == anEntry) {
				count++;
			}
		}
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return getFrequencyOf(anEntry) > 0;
	}

	@Override
	public T[] toArray() {
		/**
		 * Retrieves all entries that are in this bag.
		 * 
		 * @return A newly allocated array of all the entries in the bag.
		 */

		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
		for (int index = 0; index < numberOfEntries; index++) {
			result[index] = bag[index];
		} // end for
		return result;
	} // end toArray

}
