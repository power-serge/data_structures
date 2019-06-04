package chapter06;

import java.util.EmptyStackException;

import chapter05.StackInterface;

/** A class of stacks whose entries are stored in a chain of nodes. */
public final class LinkedStack<T> implements StackInterface<T> {

	private static class Node<T> {
		public T data;
		public Node<T> next;

		@SuppressWarnings("unused")
		public Node(T inputData) {
			this(inputData, null);
		}

		public Node(T inputData, Node<T> inputNext) {
			data = inputData;
			next = inputNext;
		}
	}

	@SuppressWarnings("rawtypes")
	private Node topNode; // References the first node in the chain

	public LinkedStack() {
		topNode = null;
	} // end default constructor

	@Override
	public boolean isEmpty() {
		return topNode == null;
	} // end isEmpty

	@Override
	public T pop() {
		T top = peek(); // Might throw EmptyStackException
		// Assertion: topNode != null
		topNode = topNode.next;
		return top;
	} // end pop

	@SuppressWarnings("unchecked")
	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		else
			return (T) topNode.data;
	} // end peek

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	} // end push

	@Override
	public void clear() {
		topNode = null;
	}
}// end LinkedStack