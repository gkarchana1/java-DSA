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

	public ListNode getNthNodeFromEnd(int n){

		if( head == null){
			return null;
		}
		
		if( n <= 0 ){
			throw new IllegalArgumentException("\n" + "Invalid value");
		}

		ListNode mainPtr = head;
		ListNode refPtr = head;

		int count = 0;

		while( count < n ){
			if( refPtr == null ){
				throw new IllegalArgumentException("\n" + n + " is greater than  the number of nodes in list");
			}

			refPtr = refPtr.next;
			count++;
		}

		while( refPtr != null ){

			mainPtr = mainPtr.next;
			refPtr = refPtr.next;
		}

		return mainPtr;
	}

	public static void main( String args[] ){

		SinglyLinkedList s = new SinglyLinkedList();

		s.head = new ListNode(1);
		
		s.insertFirst(2);
		s.insertFirst(3);
		s.insertFirst(4);
		s.insertFirst(5);

		s.display( s.head );

		ListNode n = s.getNthNodeFromEnd(2);
		System.out.println("\nNth Node from end is " + n.data);


	}
}
