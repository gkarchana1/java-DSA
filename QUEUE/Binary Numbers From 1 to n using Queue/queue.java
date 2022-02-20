import java.util.*;;

class queue{

	public String[] generateBinaryNumbers( int n ){

		String[] result = new String[n];
		Queue<String> queue = new LinkedList<>();

		queue.offer("1");
		for( int i = 0; i < n; i++ ){

			result[i] = queue.poll();
			String n1 = result[i] + "0";
			String n2 = result[i] + "1";

			queue.offer(n1);
			queue.offer(n2);
		}

		return result;
	}

	public static void main( String args[] ){

		queue q = new queue();
		String result[] = q.generateBinaryNumbers( 5 );
		
		System.out.println("\nBinary Numbers From 1 to n");	

		for( String s: result){
			System.out.print( s + " " );
		}
	}
}