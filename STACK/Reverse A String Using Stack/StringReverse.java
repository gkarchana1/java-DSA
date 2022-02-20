import java.util.Stack;

class StringReverse{

	public static String reverse( String str ){

		Stack<Character> s = new Stack<Character>();
		char[] ch = str.toCharArray();

		for( char c: ch){
			s.push(c);
		}

		for( int i = 0; i < ch.length; i++){

			ch[i] = s.pop();
		}

		return new String( ch );
		
	}

	public static void main( String args[] ){

		String name = "archana";		
		System.out.println("\nBefore Reversing: " + name);
		System.out.println("\nAfter Reversing: " + reverse( name ) );
	}
}