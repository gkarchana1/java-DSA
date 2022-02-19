class CircularSinglyLinkedList{

	private ListNode last;
	private int length;

	public static class ListNode{

		private int data;
		private ListNode next;

		public ListNode( int data ){

			this.data = data;
			this.next = null;
		}
	}

	CircularSinglyLinkedList(){
		this.last = null;
		this.length = 0;
	}

	public void createCircularSinglyLinkedList(){
		
		ListNode first = new ListNode(1);
		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);

		first.next = second;
		second.next = third;
		third.next = fourth;
		
		fourth.next = first;
		last = fourth;
	}

	public int length(){
		return length;
	}

	public boolean isEmpty(){
		return (length == 0);
	}

	//Insert A newNode At first
	public void insertFirst( int data ){

		ListNode newNode = new ListNode( data );

		if( last == null ){

			last = newNode;
		}
		else{
			newNode.next = last.next;
		}
	
		last.next = newNode;
		length++;
	}

	//Insert A newNode At Last
	public void insertLast( int data ){

		ListNode newNode = new ListNode( data );

		if( last == null ){
			last = newNode;
		}
		else{
			newNode.next = last.next;
		}

		last.next = newNode;
		last = newNode;	
		length++;
		
	}

	//Delete First Element
	public void removeFirst(){

		if( isEmpty() ){
			System.out.println("\nEmpty");
			return;
		}
		else if( last == last.next ){

			ListNode temp = last.next;

			System.out.println("\n" + last.data + " is deleted.");
			last = null;	
			temp.next = null;			
		}
		else{

			ListNode temp = last.next;
		
			System.out.println("\n" + last.next.data +  " is deleted.");
			last.next = last.next.next;	
			temp.next = null;			
		}

		length--;

	}

	//Delete Last Element
	public void removeLast(){

		if( isEmpty() ){
			System.out.println("\nEmpty");
			return;
		}

		ListNode temp = last.next;
		ListNode current = null;
		ListNode first = last.next;

		System.out.println("\n" + last.data + " is deleted.");

		if( last == last.next){
			last = null;
		}
		else{
			
			while( temp != last ){
				current = temp;
				temp = temp.next;
			}

			current.next = first;
			last.next = null;
			last = current;

		}
		length--;
	}

	//Traverse through Circular Singly LinkedList
	public void display(){
		
		if( last == null ){

			System.out.println("\nEmpty");
			return;
		}
		ListNode first = last.next;

		while( first != last ){
			System.out.print(first.data + "-->");
			first = first.next;
		}

		System.out.println(first.data);
	}
	public static void main( String args[] ){

		CircularSinglyLinkedList c  = new CircularSinglyLinkedList();

		c.createCircularSinglyLinkedList();

		c.insertFirst(10);
		c.insertFirst(18);

		c.insertLast(20);
		c.display();

		c.removeFirst();
		c.display();	

		c.removeLast();
		c.display();
	}
}