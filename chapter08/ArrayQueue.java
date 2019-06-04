package chapter08;

/*****************************************************************************
 * This is an implementation of a dynamic wraparound queue structure.
 *  *****************************************************************************/



@SuppressWarnings("unchecked")
public class ArrayQueue<T> implements  QueueInterface<T>
{
	private static final int DEFAULT_CAPACITY = 10;
	private int cap,	// total number of elements in the queue
                  cur,		// current number of elements
                  front,  	// front index
			back; // back index
	private T[] A;

	/**
	*  Creates a new empty queue.
	*/
	public ArrayQueue ()
	{
		cap = DEFAULT_CAPACITY;
		A = (T[]) new Object[DEFAULT_CAPACITY];
		back =cap-1; 
		front = 0;
		cur=0;
	}

	/**
	*  Tests if the queue is logically empty.
	*
	*  @return true if the queue is empty and false otherwise
	*/
	public boolean isEmpty()
	{
		return cur == 0;
	}

	/**
	*  Puts a data into the back of the queue. It works with wraparound.
	*  If the queue is full, throw an exception.
	*
	*  @param value the item to insert.
	*  @throws QueueException if the queue is full.
	*/
	public void enqueue (T data)
	{
		if (isFull()) 
			throw new QueueException("Queue is full");
		back=(back+1)%cap;
		A[back] = data;
		cur++;
	}

	/**
	*  Returns the first element in the queue.
	*
	*  @return element at front of the queue
	*  @throws QueueException if the queue is empty.
	*/
	public T peekFront()
	{
		if (isEmpty())
			throw new QueueException("Queue is empty");
		else
			return A[front];
	}

	/**
	*  Returns and removes the front element of the queue. It works with wraparound.
	*
	*  @return element at front of the queue
	*  @throws QueueException if the queue is empty.
	*/
	public T dequeue()
	{
		T buffer = peekFront();
		A[front] = null; // for garbage collection
		front=(front+1)%cap;
		cur--;
		return buffer;
	}

	/**
	*  Makes the queue physically empty.
	*
	*/
	public void clear()
	{
		for(int i = 0; i < cap; i++) 
			A[i] = null;
		cur = 0; 
		back = cap-1; 
		front = 0;
	}

	/**
	*  Tests if the queue is logically full
	*/
	private boolean isFull()
	{
		return cur == cap;
	}
 
	/**
	   * Returns a string representation of the Queue.
	   */
	   public String toString()
	   {
	      if(isEmpty()) return "[ ]";

	      StringBuffer out = new StringBuffer("[");
	      for(int i = 0; i <cap-1; i++)
	         out.append(A[i] + ", ");
	      out.append(A[cap-1] + "]");
	      return out.toString();
	   }
	

	   public static void main(String[] args)
	   {
		   ArrayQueue<Integer> q = new ArrayQueue<Integer>();
	   
		   try
		   {
			  System.out.println("Enqueue:");
		      for(int i = 0; i < 10; i++) 
		      {	 
		    	  q.enqueue(i);
		    	  System.out.println(q);
		      }
		
		      System.out.println("Dequeue:");
		      for(int i = 0; i < 5; i++) {
		     	 q.dequeue();
		     	 System.out.println(q);
		      }
		
		      System.out.println("Enqueue again:");
		      for(int i = 10; i <= 12; i++) {
			   	 q.enqueue(i);
			   	 System.out.println(q);
		      }
			
		   }
		   catch (QueueException e)
		   {
		      System.err.println(e);
		   }
	   }

}
///////////////////////////////////////////
//              QueueInterface           
///////////////////////////////////////////

interface QueueInterface<T>
{
	/**
	* Tests if the Queue is empty.
	*/
	public boolean isEmpty();

	/**
	*  Removes and returns the front item
	*/
	public T dequeue() throws QueueException;

	/**
	*  Returns the front item without its removal
	*/
	public T peekFront() throws QueueException;

	/**
	* Inserts an item to the back
	*/
	public void enqueue(T e);

	/**
	* Removes all items from the Queue.
	*/
	public void clear();
}
///////////////////////////////////////////
//              QueueException           
///////////////////////////////////////////


class QueueException extends RuntimeException
{
	public QueueException(String name)
	{
		super(name);
	}

	public QueueException()
	{
		super();
	}
}
