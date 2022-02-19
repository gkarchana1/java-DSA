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

	public boolean detectLoop(){

		if( head == null ){
			return false;
		}

		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while( fastPtr != null && fastPtr.next != null ){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;

			if( slowPtr == fastPtr ){
				return true;
			}			
		}
		return false;
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

		System.out.println("\n" + "Loop exists: " + s.detectLoop());

	
	}
}