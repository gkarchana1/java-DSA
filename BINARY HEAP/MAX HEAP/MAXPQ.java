public class MAXPQ{
	
	private Integer[] heap;
	private int n;

	public MAXPQ( int capacity ){
		heap = new Integer[capacity + 1];
		n = 0;
	}

	//Check whether max heap is empty
	public boolean isEmpty(){
	
		return (n==0);
	}
	
	//Returns number of elements in Max Heap
	public int size(){
		return n;
	}

	//Resize an Array
	public void resize( int capacity ){

		Integer temp[] = new Integer[capacity];
		
		for( int i = 0; i < heap.length; i++ ){
			temp[i] = heap[i];
		}

		heap = temp;
	}
	
	//Bottom up approach. Heapify
	public void swim( int k){

		while( k>1 && heap[k/2] < heap[k] ){
			int temp = heap[k/2];
			heap[k/2] = heap[k];
			heap[k] = temp;
			k = k/2;
		}	
	}

	//To insert an element in Max Heap
	public void insert( int element ){

		if( n==heap.length-1 ){
			resize(2*(heap.length));
		}

		n++;
		heap[n] = element;
		swim(n);
	}

	//To Print Max Heap
	public void printMaxHeap(){

		if( isEmpty() ){
			System.out.println("No elements to print in Max Heap");
			return;
		}
		for( int i = 1; i <= n; i++ ){
			System.out.print(heap[i] + " ");
		}

	}

	//Top down approach
	public void sink(int i){
		int k;

		while( 2*i < n ){
		if( heap[2*i + 1] < heap[2*i] ){
			k = 2*i;
		}
		else{
			k = 2*i + 1;
		}

		if( heap[i] < heap[k]){
			swap(k, i);
			i = k;
			
		}
		else
			break;
		}
	}
	
	//Deletes Root element
	public int deleteMax(){
		int max;
			
		if( isEmpty() )
			return -1;

		max = heap[1];

		swap( 1, n );	
		n--;
		heap[n+1] = null;

		sink(1);
		return max;
	}

	public void swap(int x, int y){
		int temp = heap[x];
		heap[x] = heap[y];
		heap[y] = temp;	
	}

	public static void main( String args[] ){
	
		MAXPQ mpq = new MAXPQ( 3 );
		mpq.insert(1);
		mpq.insert(2);
		mpq.insert(10);
		mpq.insert(12);
		mpq.insert(3);
		System.out.println(mpq.size() + " elements are in max heap");
		mpq.printMaxHeap();
		System.out.println("\n" + mpq.deleteMax() + " is deleted");

		System.out.println(mpq.size() + " elements are in max heap");
		mpq.printMaxHeap();

	}
}