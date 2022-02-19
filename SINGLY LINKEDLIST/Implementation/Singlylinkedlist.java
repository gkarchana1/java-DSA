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
	
	public ListNode deleteFirst(){

		if( head == null ){
			return null;
		}

		else{
			ListNode temp = head;
			head = head.next;
			temp.next = null;
			return temp;
		}
	}

	public ListNode deleteLast(){
	
		if( head == null || head.next == null){
			
			return head;
		}	
		else{
			ListNode current = head;
			
			while( current.next.next != null ){
				current = current.next;
			}

			ListNode temp = current.next;
			temp.next = null;

			current.next = null;

			return temp;
		}
	}
	
	public ListNode deleteAnywhere(int position){

		if( position == 1 ){

			ListNode current = head;
			head = head.next;
			current.next = null;


			return current;
		}
		else{
			ListNode current = head;
			int num = 1;

			while( num < position-1 ){
				current = current.next;
				num++;
			}
			
			ListNode temp = current.next;
			current.next = current.next.next;

			return temp;
		}
	}

	public int count(){

		if(head == null){
			return 0;
		}
		else{

			ListNode current = head;
			int count = 0;

			while( current != null ){

				count++;
				current = current.next;
			}

			return count;
		}
	}

	public boolean find( int searchKey ){

		if( head == null )
			return false;
		else{
			
			ListNode current = head;

			while( current != null ){

				if( current.data == searchKey)
					return true;
				else
					current = current.next;
				
			}
		}
		return false;
	}

	public static void main( String args[] ){

		Singlylinkedlist s = new Singlylinkedlist();
		
		s.insertLast(10);
		s.insertLast(11);
		s.insertLast(12);
		s.insertLast(13);
		
		s.insertAnywhere(5, 15);

		System.out.println("Total number of nodes: " + s.count());

		s.display();

		System.out.println("\nFirst node " + s.deleteFirst().data + " is deleted.");

		s.display();

		System.out.println("\nLast node " + s.deleteLast().data + " is deleted.");

		s.display();

		System.out.println("\nNode " + s.deleteAnywhere(1).data + " is deleted.");

		s.display();

		if( s.find(1) )
			System.out.println("searchKey found");
		else
			System.out.println("searchKey not found");
	}
}