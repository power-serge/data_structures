package Project4;

public class CArrayDeque<T> {

	private T[] items;
	private int front;
	private int back;
	private int size;
	final static int CAPACITY = 10;

	// Default constructor
	@SuppressWarnings("unchecked")
	public CArrayDeque() {
		items = (T[]) new Object[CAPACITY];
		front = 0;
		back = CAPACITY - 1;
		size = 0;
	}

	/**
	 * Sees whether this queue is empty.
	 * 
	 * @return True if the queue is empty, or false if not.
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Adds a new entry to this queue at front.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean addFront(T newEntry) {
		if (size < CAPACITY) {
			if (front != 0) {
				front--;
			} else {
				front = CAPACITY-1;
			}
			items[front] = newEntry;
			size++;
			return true;
		}
		return false;
	}

	/**
	 * Adds a new entry to this queue at back.
	 * 
	 * @param newEntry The object to be added as a new entry.
	 * @return True if the addition is successful, or false if not.
	 */
	public boolean addBack(T newEntry) {
		if (size < CAPACITY) {
			if (back == CAPACITY - 1)
				back = 0;
			else
				back++;
				//back = (back + 1) % CAPACITY;
			items[back] = newEntry;
			size++;
			return true;
		}

		return false;
	}

	/**
	 * Removes the entry at front from the queue, if possible.
	 * 
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean removeFront() {
		if (!isEmpty()) {
			items[front] = null;
			//front++;
			front = (front + 1) % items.length;
			size--;
			return true;
		}
		return false;
	}

	/**
	 * Removes the entry at back from the queue, if possible.
	 * 
	 * @return True if the removal was successful, or false if not.
	 */
	public boolean removeBack() {
		if (!isEmpty()) {
			items[back] = null;
			if (back == 0)
				back = CAPACITY - 1;
			else
				back--;
//				back = (back - 1 + CAPACITY) % CAPACITY;
			size--;
			return true;
		}
		return false;
	}

	/**
	 * Retrieve the entry at front in the queue, if possible.
	 * 
	 * @return the front entry if the retrieve was successful, or null if not.
	 */
	public T retrieveFront() {
		if (!isEmpty()) {
			return items[front];
		}
		return null;
	}

	/**
	 * Retrieve the entry at back in the queue, if possible.
	 * 
	 * @return the front entry if the retrieve was successful, or null if not.
	 */
	public T retrieveBack() {
		if (!isEmpty()) {
			return items[back];
		}
		return null;
	}

	/**
	 * Retrieves all entries that are in this queue.
	 * 
	 * @return A newly allocated array of all the entries in this queue.
	 */
	@SuppressWarnings("unchecked")
	public T[] toArray() {
		T[] temp = (T[]) new Object[CAPACITY];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = items[i];
		}
		return temp;
	}

}
