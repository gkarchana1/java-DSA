import java.util.*;

public class Stack{

	private ListNode top;
	private int length;

	public static class ListNode{

		private int data;
		private ListNode next;

		public ListNode( int data ){

			this.data = data;
			this.next = null;
		}
	}

	public Stack(){

		this.top = null;
		this.length = 0;
	}

	public boolean isEmpty(){
		return (length == 0 );
	}

	public int length(){
		return length;
	}

	public void push( int data ){

		ListNode newNode = new ListNode( data );
		
		newNode.next = top;
		top = newNode;
		length++;

	}

	public int pop(){

		if( isEmpty() ){
			throw new EmptyStackException();
		}

		ListNode temp = top;
		top = top.next;
		temp.next = null;
		length--;
		return temp.data;

		
	}

	public int peek(){
		if( isEmpty() ){
			throw new EmptyStackException();
		}

		return top.data;

	}
	
	public static void main( String args[] ){

		Stack sk = new Stack();

		sk.push(11);
		sk.push(16);
		sk.push(18);

		System.out.println(sk.peek());
		System.out.print(sk.pop() + " " + sk.pop() + " " + sk.pop());


	}
}