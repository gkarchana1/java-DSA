public class SinglyLinkedList{

	private ListNode head1;
	private ListNode head2;

	public static class ListNode{

		private int data;
		private ListNode next;
		
		public ListNode( int data ){
			this.data = data;
			this.next = null;
		}
	}


	public void display( ListNode head ){

		if( head == null ){

			System.out.println("\nhead is null");
			return;
		}

		ListNode current = head;

		while( current != null ){

			System.out.print( current.data + "-->");
			current = current.next;
		}

		System.out.println("null\n");
		
	}

	public ListNode insertFirst( ListNode head, int data ){

		ListNode newNode = new ListNode( data );

		newNode.next = head;
		head = newNode;

		return head;
	}

	public ListNode merge( ListNode a, ListNode b ){

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;
		
		while( a != null && b != null ){

			if( a.data <= b.data ){

				tail.next = a;
				a = a.next;
			}
			else{
		
				tail.next = b;
				b = b.next;
			}
			tail = tail.next;
		}

		if( a == null ){
			tail.next = b;
		}
		else{
			tail.next = a;
		}

		return dummy.next;
	}

	public static void main( String args[] ){

		SinglyLinkedList s = new SinglyLinkedList();

		s.head1 = new ListNode(8);
		s.head1 = s.insertFirst(s.head1, 4);
		s.head1 = s.insertFirst(s.head1, 1);

		s.display( s.head1 );

		s.head2 = new ListNode(6);
		s.head2 = s.insertFirst(s.head2, 3);

		s.display( s.head2 );

		System.out.println("Merged Two Sorted Lists");
		ListNode head = s.merge( s.head1, s.head2 );

		s.display( head );
	}
}
