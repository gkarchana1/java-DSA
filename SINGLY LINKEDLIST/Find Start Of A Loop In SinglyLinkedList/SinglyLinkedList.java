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

	public void display( ListNode head ){
		
		ListNode temp = head;

		while( temp != null ){
	
		System.out.print(temp.data + "-->");
			temp = temp.next;
		}

		System.out.print("null");
	}

	public ListNode getStartingNode( ListNode slowPtr ){

		ListNode temp = head;

		while( slowPtr != temp ){

			temp = temp.next;
			slowPtr = slowPtr.next;
		}
		return temp;
	}

	public ListNode detectLoop(){

		if( head == null ){
			System.out.println("\nNo Loop");
			return null;
		}

		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while( fastPtr != null && fastPtr.next != null ){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if( slowPtr == fastPtr ){
				System.out.println("\n Loop exists");
				return getStartingNode( slowPtr );
			}			
		}
		System.out.println("\nNo Loop");
		return null;
	}

	public static void main( String args[] ){

		SinglyLinkedList s = new SinglyLinkedList();

		s.head = new ListNode(1);

		ListNode second = new ListNode(2);
		ListNode third = new ListNode(3);
		ListNode fourth = new ListNode(4);
		ListNode fifth = new ListNode(5);
		ListNode sixth = new ListNode(6);

		s.head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		fifth.next = sixth;

		sixth.next = third;

		ListNode temp = s.detectLoop();
		
		if( temp != null )
			System.out.println("\n Loop starts from " + temp.data);

	
	}
}