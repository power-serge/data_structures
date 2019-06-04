package chapter06;

import chapter05.StackInterface;

@SuppressWarnings("unchecked")
public class ArrayStack<T> implements StackInterface<T> {
	private static final int DEFAULT_CAPACITY = 15;
	private int top; // reference to the top element
	private T[] A;

	/**
	 * Creates a Stack of the size Capacity
	 */
	public ArrayStack(int Capacity) {
		if (Capacity <= 0)
			A = (T[]) new Object[DEFAULT_CAPACITY];
		else
			A = (T[]) new Object[Capacity];

		top = -1; // stack is empty
	}

	/**
	 * Creates a Stack with the default capacity
	 */
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	/**
	 * Tests if the stack is empty.
	 */
	public boolean isEmpty() {
		return top == -1;
	}

	/**
	 * Returns the top item without its removal.
	 */
	public T peek() {
		if (isEmpty())
			throw new StackException("Stack is empty");
		return A[top];
	}

	/**
	 * Removes and returns the item at the top of this stack.
	 */
	public T pop() {
		T x = peek();
		A[top] = null;
		top--;
		return x;
	}

	/**
	 * Inserts an item onto the top of the stack.
	 */
	public void push(T e) {
		if (top == A.length - 1) // Stack is full.
			throw new StackException("Stack has overflowed");
		top++;
		A[top] = e;
	}

	/**
	 * Removes all items from the Stack.
	 */
	public void clear() {
		for (int i = 0; i <= top; i++)
			A[i] = null;
		top = -1;
	}

	/**
	 * Returns a string representation of the Stack.
	 */
	public String toString() {
		if (isEmpty())
			return "[ ]";

		StringBuffer out = new StringBuffer("[");
		for (int i = 0; i < top; i++)
			out.append(A[i] + ", ");
		out.append(A[top] + "]");
		return out.toString();
	}

	public static void main(String[] args) {
		ArrayStack<Integer> s = new ArrayStack<Integer>(10);
		try {
			for (int i = 0; i < 6; i++)
				s.push(i);
			System.out.println(s);
			for (int i = 0; i < 4; i++)
				s.pop();
			System.out.println(s);
		} catch (StackException e) {
			System.err.println(e);
		}
	}
}

////////////////////////////////////////////
//              StackException           
////////////////////////////////////////////
//class StackException extends RuntimeException {
//	public StackException(String name) {
//		super(name);
//	}
//
//	public StackException() {
//		super();
//	}
//}