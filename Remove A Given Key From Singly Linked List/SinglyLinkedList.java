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

	public void insertLast( int data ){

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

	public void deleteNode( int key ){

		if( head.data == key && head != null ){
			System.out.println("\n\n" + key + " is deleted");
			head = head.next;
			return;
		}

		ListNode current = head;
		ListNode temp = null;

		while( current != null && current.data != key ){
			temp = current;
			current = current.next;
		}

		if( current == null ){
			System.out.println("\n\n" + key + " is not found");
			return;
		}

		temp.next = current.next;
		System.out.println("\n\n" + key + " is deleted");
	}

	public static void main( String args[] ){

		SinglyLinkedList s = new SinglyLinkedList();

		s.head = new ListNode(18);

		s.insertLast(10);		
		s.insertLast(7);
		s.insertLast(4);
		s.insertLast(2);
		s.insertLast(1);

		s.display( s.head );

		s.deleteNode(10);
	
		System.out.println();
		s.display( s.head );		
	}
}
