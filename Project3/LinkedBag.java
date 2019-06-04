package Project3;

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 */

public class LinkedBag<T> implements BagInterface<T> {

	private class Node {
		private T data; // Entry in bag
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor
	} // end Node

	private Node firstNode; // Reference to first node
	private int numberOfEntries;

	// Default constructor
	public LinkedBag() {
		firstNode = null;
		numberOfEntries = 0;

	} // end default constructor

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return firstNode == null;
	}

	@Override
	public boolean add(T newEntry) {
		// TODO Auto-generated method stub
		Node newNode = new Node(newEntry, firstNode);
		firstNode = newNode;
		numberOfEntries++;

		return true;
	}

	@Override
	public T remove() {
		// TODO Auto-generated method stub
		if (isEmpty())
			return null;
		T buffer = firstNode.data;
		firstNode = firstNode.next;
		numberOfEntries--;
		return buffer;
	}

	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry) {
		Node currentNode;
		for (currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			if (anEntry == currentNode.data)
				return currentNode;
		} // end while
		return currentNode;
	} // end getReferenceTo

	@Override
	public boolean remove(T anEntry) {
//		boolean flag = false;
//		//while (this.contains(anEntry)) {
//		while (getReferenceTo(anEntry)!= null) {
//			Node TargetNode = getReferenceTo(anEntry);
//			if (TargetNode != null) {
//				TargetNode.data = firstNode.data;
//				firstNode = firstNode.next;
//				numberOfEntries--;
//				flag = true;
//			}
		boolean flag = false;
		Node target = getReferenceTo(anEntry);
		while (target != null) {			
				target.data = firstNode.data;
				firstNode = firstNode.next;
				numberOfEntries--;
				flag = true;
			}
		return flag;
	}

	@Override
	public void clear() {
		numberOfEntries = 0;
		firstNode = null;

	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int count = 0;
		Node currentNode;
		for (currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			if (anEntry == currentNode.data)
				count++;
		} // end while
		return count;
	}

	@Override
	public boolean contains(T anEntry) {
		Node currentNode;

		for (currentNode = firstNode; currentNode != null; currentNode = currentNode.next) {
			if (anEntry == currentNode.data)
				return true;
		}
		return false;
//		boolean found = false;
//		Node currentNode = firstNode;
//		while (!found && (currentNode != null)) {
//			if (anEntry.equals(currentNode.data))
//				found = true;
//			else
//				currentNode = currentNode.next;
//		}
//		return found;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		Node current = firstNode;
		T[] temp = (T[]) new Object[numberOfEntries];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = current.data;
			current = current.next;
		}
		return temp;
	}

}
