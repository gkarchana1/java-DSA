import java.util.*;

public class Queue{

	private ListNode rear;
	private ListNode front;
	private int length;

	public static class ListNode{
		private int data;
		private ListNode next;

		public ListNode( int data ){
			this.data = data;
			this.next = null;
		}
	}

	public Queue(){
		this.front = null;
		this.rear = null;
		this.length = 0;
	}

	public boolean isEmpty(){
		return (length==0);
	}

	public int length(){
		return length;
	}

	public void enqueue( int data ){

		ListNode newNode = new ListNode( data );

		if( isEmpty() ){
			front = newNode;;
		}
		else{
			rear.next = newNode;

		}
		rear = newNode;		
		length++;
	}

	public int dequeue(){

		if( isEmpty() ){
			throw new NoSuchElementException();
		}

		int element = front.data;

		if( front == rear ){
			
			front = rear = null;
		}
		else{
			
			front = front.next;
		}

		length--;
		return element;

	}

	public int first(){

		if( isEmpty() ){
			throw new NoSuchElementException();
		}

		return front.data;
	}

	public int last(){

		if( isEmpty() ){
			throw new NoSuchElementException();
		}

		return rear.data;
	}

	public void traverse(){

		if( isEmpty() ){
			System.out.println("Queue Empty");
			return;
		}
		else{

			ListNode current = front;

		System.out.println();

			while( current != null ){
				System.out.print(current.data + "-->");
				current = current.next;
			}
			System.out.println("null");
		}
	}

	public static void main( String args[] ){

		Queue q = new Queue();
		q.enqueue(18);
		q.enqueue(10);
		q.enqueue(6);	

		q.traverse();

		System.out.println("\nDeleted: " + q.dequeue());

		q.traverse();

		System.out.println("\nFirst Element " + q.first());
	
		System.out.println("\nLast Element " + q.last());
	}

}