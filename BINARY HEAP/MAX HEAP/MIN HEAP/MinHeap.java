public class MinHeap{

	private Integer heap[];
	private int n;

	public MinHeap(int capacity){

		heap = new Integer[capacity+1];
		n = 0;
	}

	public boolean isEmpty(){
		return (n==0);
	}

	public int size(){
		return n;
	}
	
	public void resize(int capacity){

		Integer[] temp = new Integer[capacity];

		for( int i = 0; i < heap.length; i++){
			temp[i] = heap[i];
		}

		heap = temp;
	}
	
	public void swim( int k ){

		while( k > 1 && heap[k/2] > heap[k]){
			int temp;
			temp = heap[k/2];
			heap[k/2] = heap[k];
			heap[k] = temp;
			k = k/2;
		}
	}

	public void insert( int x ){
		
		if( n == heap.length-1 ){
			resize(2*(heap.length));
		}		

		n++;
		heap[n] = x;
		swim(n);
	}

	public void swap( int x, int y){

		int temp = heap[x];
		heap[x] = heap[y];
		heap[y] = temp;
	}

	public void sink(int i){

		while(2*i <  n){

			int j = 2*i;
		
			if(heap[2*i + 1] < heap[2*i] ){

				j = 2*i + 1;
			}


			if( heap[i] > heap[j] ){

				swap( j, i);
				i = j;
			}
			else
				break;
		}

		
		
	}	
	
	public int deleteMin(){
		
		if( isEmpty() ){
			System.out.println("No elements in MinHeap to print");
			return -1;
		}

		int min = heap[1];

		swap(1, n);
		n--;		
		heap[n+1] = null;

		sink(1);
		return min;
	}

	
	
	public void printMinHeap(){

		if( isEmpty() ){
			System.out.println("No elements to print.");
			return;
		}

		for( int i = 1; i <= n; i++ ){
			System.out.print(heap[i] + " ");
		}
	}

	public static void main( String args[] ){

		MinHeap mh = new MinHeap(4);
		mh.insert(5);
		mh.insert(10);
		mh.insert(3);

		mh.printMinHeap();
		System.out.println("\n" + mh.deleteMin() + " is deleted");
		mh.printMinHeap();		
System.out.println("\n" + mh.deleteMin() + " is deleted");
		mh.printMinHeap();		
		

	}
}