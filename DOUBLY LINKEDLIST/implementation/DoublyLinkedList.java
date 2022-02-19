public class DoublyLinkedList{

	private ListNode head;
	private ListNode tail;
	private int length;

	private class ListNode{
		
		private int data;
		private ListNode next;
		private ListNode previous;

		public ListNode( int data ){
			
			this.data = data;
			this.next = null;
			this.previous = null;
		}
	}

	public DoublyLinkedList(){

		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public boolean isEmpty(){
	
		return (length == 0);
	}

	public int length(){
		
		return length;
	}

	//Insert newNode at First
	public void insertFirst( int data ){

		ListNode newNode = new ListNode(data);

		if( isEmpty() ){
			tail = newNode;
		}
		else{
			head.previous = newNode;
		}

		newNode.next = head;
		head = newNode;
		length++;
	}

	//Insert newNode at Last
	public void insertLast( int data ){

		ListNode newNode = new ListNode(data);

		if( isEmpty() ){
			head = newNode;
		}
		else{
			tail.next = newNode;
		}

		newNode.previous = tail;
		tail = newNode;
		length++;
	}

	/*
	ANOTHER METHOD
	public void insertLast( int data ){

		ListNode newNode = new ListNode( data );

		if( head == null && tail == null ){
			
			head = tail = newNode;
		}

		else{

			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode;

		}
	}
	*/

	//Delete First Node
	public void deleteFirst(){

		ListNode temp = head;

		if( isEmpty() ){
			System.out.println("\nEmpty");
		}

		else{
	
			if( head == tail ){
				tail = null;
			}		
			else{
				head.next.previous = null;
			}

			System.out.println("\nFirst element " + head.data + " is deleted.");
			head = head.next;
			temp.next = null;
			length--;
		}
	}

	//Delete Last Node
	public void deleteLast(){

		ListNode temp = tail;

		if( isEmpty() ){
			System.out.println("\nEmpty");
		}
		else{

			if( head == tail ){
				head = null;
			}
			else{
				tail.previous.next = null;
			}

			System.out.println("\nLast element " + tail.data + " is deleted.");

			tail = tail.previous;
			temp.previous = null;

			length--;
		}
	}

	//Forward Display using Head node
	public void displayForward(){

		if( head == null ){
			System.out.println("\nEmpty");
			return;
		}

		ListNode current = head;

		while( current != null ){

			System.out.print(current.data + "-->");
			current = current.next;
		}

		System.out.println("null");
	}

	//Reverse Display Using Tail Node
	public void displayBackward(){

		if( head == null ){
			System.out.println("\nEmpty");
			return;
		}

		ListNode current = tail;

		while( current != null ){

			System.out.print(current.data + "-->");
			current = current.previous;
		}
		System.out.println("null");
	}

	public static void main( String args[] ){

		DoublyLinkedList d = new DoublyLinkedList();
		d.insertLast(10);
		d.insertLast(5);
		d.insertLast(15);

		d.insertFirst(18);

		d.displayForward();
		d.displayBackward();

		d.deleteFirst();

		d.displayForward();
		d.displayBackward();

		d.deleteLast();

		d.displayForward();
		d.displayBackward();
	}
}