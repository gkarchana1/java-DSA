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

	public ListNode getMiddleNode(){

		if( head == null )
			return head;

		ListNode slowPtr = head;
		ListNode fastPtr = head;

		while( fastPtr != null && fastPtr.next != null){
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		
		}

		return slowPtr;
	}

	public static void main( String args[] ){

		SinglyLinkedList s = new SinglyLinkedList();

		s.head = new ListNode(1);
		
		s.insertFirst(2);
		s.insertFirst(3);

		s.display( s.head );

		ListNode middleNode = s.getMiddleNode();
		System.out.println("\nMiddle Element is " + middleNode.data);
	}
}
