package chapter08;


public class ListQueue<T> implements QueueInterface<T> {
	private Node<T> front, back;

	/**
	 * Creates a Queue
	 */
	public ListQueue() {
		front = null;
		back = null;
	}

	/**
	 * Tests if the queue is empty.
	 */
	public boolean isEmpty() {
		return front == null;
	}

	/**
	 * Make the queue logically empty.
	 */
	public void clear() {
		front = null;
		back = null;
	}

	/**
	 * Inserts an item at the back of the queue.
	 */
	public void enqueue(T newData) {

		Node<T> newNode = new Node<T>(newData, null);
		if (back == null) // the queue is empty
			front = newNode;
		else
			back.next = newNode;
		back = newNode;
	}

	/**
	 * Removes and returns the item at the front of this queue.
	 */
	public T dequeue() {
		T buffer = peekFront();
		front = front.next;
		if (front == null)
			back = null;
		return buffer;
	}

	/**
	 * Returns the top item without its removal
	 */
	public T peekFront() {
		if (isEmpty())
			throw new QueueException("Queue is empty");
		return front.data;
	}

	/**
	 * Returns a string representation of the Queue.
	 */
	public String toString() {
		if (isEmpty())
			return "[ ]";

		StringBuffer out = new StringBuffer("[");
		Node<T> tmp = front;
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
		ListQueue<Integer> q = new ListQueue<Integer>();

		try {
			for (int i = 0; i < 6; i++)
				q.enqueue(i);

			System.out.println(q);

			for (int i = 0; i < 5; i++)
				q.dequeue();

			System.out.println(q);

		} catch (QueueException e) {
			System.err.println(e);
		}
	}
}


