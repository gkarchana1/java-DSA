import java.util.Stack;

class stack{

	public static int[] nextGreaterElement( int arr[] ){

		int[] result = new int[arr.length];

		Stack<Integer> stack = new Stack<>();

		for( int i = arr.length-1; i >= 0; i--){

			if( !stack.isEmpty() ){
				while( (!stack.isEmpty()) && (stack.peek() <= arr[i]) ){
					stack.pop();

				}
			}

		if( stack.isEmpty() ){
			result[i] = -1;
		}
		else{
			result[i] = stack.peek();
		}

		stack.push(arr[i]);
		}
		
		return result;
	}

	public static void main( String args[] ){
        
        int arr[] = {4, 7, 3, 4, 8, 1};
        
        int result[] = nextGreaterElement( arr );
        
        System.out.println("Input Array");
        for( int i: arr){
            System.out.print( i + " ");
        }      
        
        System.out.println("\n\nOutput Array");
        for( int i: result){
            System.out.print( i + " ");
        }
        
	}
}