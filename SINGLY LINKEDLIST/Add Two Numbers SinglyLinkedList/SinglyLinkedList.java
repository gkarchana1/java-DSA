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

	public ListNode add(ListNode a, ListNode b){

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		int carry = 0;

		while( a != null || b != null ){

			int x = ( a != null ) ? a.data : 0;
			int y = ( b != null ) ? b.data : 0;

			int sum = carry + x + y;

			carry = sum / 10;
			tail.next = new ListNode( sum % 10 );

			tail = tail.next;

			if( a != null ) a = a.next;
			if( b != null ) b = b.next;
		}
		
		if( carry > 0){
			tail.next = new ListNode( carry );
		}

		return dummy.next;
	}
	public static void main( String args[] ){

		SinglyLinkedList s = new SinglyLinkedList();

		s.head1 = new ListNode(3);
		s.head1 = s.insertFirst(s.head1, 4);
		s.head1 = s.insertFirst(s.head1, 3);


		s.display( s.head1 );
		
		System.out.println("     +      \n");
		s.head2 = new ListNode(4);
		s.head2 = s.insertFirst(s.head2, 6);
		s.head2 = s.insertFirst(s.head2, 5);

		s.display( s.head2 );
		System.out.println("     =      \n");
		ListNode head = s.add( s.head1, s.head2 );
		s.display( head );
	}
}