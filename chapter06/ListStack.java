package chapter06;

import chapter05.StackInterface;

//////////////////////////////////////////////////
// A linked list-based implementation of a stack.
//////////////////////////////////////////////////

public class ListStack<T> implements StackInterface<T> {
	private Node<T> top;

	/**
	 * Creates a Stack
	 */
	public ListStack() {
		top = null;
	}

	/**
	 * Tests if the stack is empty.
	 */
	public boolean isEmpty() {
		return top == null;
	}

	/**
	 * Make the stack logically empty.
	 */
	public void clear() {
		top = null;
	}

	/**
	 * Inserts a new item into the stack.
	 */
	public void push(T newData) {
		Node newNode = new Node<T>(newData, top);
		top = newNode;
	}

	/**
	 * Removes and returns the item at the top of this stack.
	 */
	public T pop() {
		T buffer = peek();
		top = top.next;
		return buffer;
	}

	/**
	 * Returns the top item without its removal
	 */
	public T peek() {
		if (isEmpty())
			throw new StackException("Stack is empty");
		return top.data;
	}

	/**
	 * Returns a string representation of the Stack.
	 */
	public String toString() {
		if (isEmpty())
			return "[ ]";

		StringBuffer out = new StringBuffer("[");
		Node<T> tmp = top;
		while (tmp != null) {
			out.append(tmp.data + "  ");
			tmp = tmp.next;
		}
		out.append("]");
		return out.toString();
	}

	private static class Node<T> {
		public T data;
		public Node<T> next;

		public Node(T inputData) {
			this(inputData, null);
		}

		public Node(T inputData, Node<T> inputNext) {
			data = inputData;
			next = inputNext;
		}
	}

	public static void main(String[] args) {
		ListStack<Integer> s = new ListStack<Integer>();

		try {
			for (int i = 0; i < 6; i++)
				s.push(i);

			System.out.println(s);

			for (int i = 0; i < 5; i++)
				s.pop();

			System.out.println(s);

		} catch (StackException e) {
			System.err.println(e);
		}
	}
}

///////////////////////////////////////////////
//             StackException           
///////////////////////////////////////////////

class StackException extends RuntimeException {
	public StackException(String name) {
		super(name);
	}

	public StackException() {
		super();
	}
}
