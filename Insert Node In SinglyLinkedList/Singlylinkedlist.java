public class Singlylinkedlist{

	private ListNode head;

	private static class ListNode{

		private int data;
		private ListNode next;

		public ListNode(int data){

			this.data = data;
			this.next = null;
		}
	}
	
	private void display(){

		if( head == null ){
			System.out.println("SinglyLinkedlist empty");
		}

		else{
			ListNode current = head;
			
			while( current != null ){
				System.out.print( current.data + " --> " );
				current = current.next;
			}
			System.out.println("null");
		}
	}

	public void insertFirst(int data){

		ListNode newNode = new ListNode( data );
	
		if( head == null ){

			head = newNode;
		}	
		else{
		
			newNode.next = head;
			head = newNode;
		}
	}
	public void insertLast(int data){
	
		ListNode newNode = new ListNode(data);

		if( head == null ){
			head = newNode;
		}
	
		else{

			ListNode current = head;
		
			while( current.next != null ){
				current = current.next;
			}
			
			current.next = newNode;
		}
	}

	public void insertAnywhere( int position, int data ){

		ListNode newNode = new ListNode(data);
		
		if( position == 1 ){
			
			newNode.next = head;
			head = newNode;
		}

		else{
			
			ListNode current = head;
			int num = 1;

			while( num < position-1  ){

				current = current.next;
				num++;
			}

			newNode.next = current.next;
			current.next = newNode;
		}

	}

	public static void main( String args[] ){

		Singlylinkedlist s = new Singlylinkedlist();
		
		s.insertLast(10);
		s.insertLast(11);
		s.insertLast(12);
		s.insertLast(13);
		
		s.insertAnywhere(5, 15);

		s.display();

	}
}
