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

	public void removeDuplicates(){

		if( head == null ){
			return;
		}

		ListNode current = head;

		while( current != null && current.next != null ){

			if( current.data == current.next.data ){
				current.next = current.next.next;
			}

			else{
				current = current.next;
			}
		}
	}

	public static void main( String args[] ){

		SinglyLinkedList s = new SinglyLinkedList();

		s.head = new ListNode(3);

		s.insertFirst(3);		
		s.insertFirst(2);
		s.insertFirst(2);
		s.insertFirst(1);
		s.insertFirst(1);

		s.display( s.head );

		s.removeDuplicates();

		System.out.println("\n\nAfter removing duplicates in sorted Singly Linked List");

		s.display( s.head );
	}
}
