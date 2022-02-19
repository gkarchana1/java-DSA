public class SinglyLinkedList{

	public ListNode head;

	private static class ListNode{	
		private int data;
		private ListNode next;

		public ListNode( int data ){
			this.data = data;
			this.next = null;
		}
	}

	public void insertFirst( int data ){

		ListNode newNode = new ListNode( data );

		newNode.next = head;
		head = newNode;
	}

	public void display( ListNode head ){
		
		ListNode temp = head;

		while( temp != null ){
	
		System.out.print(temp.data + "-->");
			temp = temp.next;
		}

		System.out.print("null");
	}

	public void insertInSortedList( int data ){

		ListNode newNode = new ListNode( data );

		if( head == null ){
			head = newNode;
		}
		else{

			ListNode current = head;
			ListNode temp = null;

			while( current != null && current.data < newNode.data ){
				temp = current;
				current = current.next;
			}

			newNode.next = current;
			temp.next = newNode;
		}
	}

	public static void main( String args[] ){

		SinglyLinkedList s = new SinglyLinkedList();

		s.head = new ListNode(18);

		s.insertFirst(10);		
		s.insertFirst(7);
		s.insertFirst(4);
		s.insertFirst(2);
		s.insertFirst(1);

		s.display( s.head );

		s.insertInSortedList(11);

		System.out.println("\n\nAfter insertion a node in Sorted Linked List");
		s.display( s.head );

	}
}