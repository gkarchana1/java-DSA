import java.util.Stack;

class stack{

	static boolean isValid( String s ){

		Stack<Character> stack = new Stack<>();

		for( char ch: s.toCharArray() ){
			if( ch=='{' || ch=='(' || ch=='['){
				stack.push(ch);
			}
			else{
				if( stack.isEmpty() ){
					return false;
				}
				else{

					char top = stack.peek();
					if( (ch==')' && top=='(') || (ch=='}' && top=='{') || (ch==']' && top=='[')){
						stack.pop();
					}
					else{
						return false;
					}
				}
			}

		}
		return stack.isEmpty();
	}

	public static void main( String args[] ){
		String exp = "{()}";
		System.out.println("Given Expresion " + exp + " is valid: " + isValid(exp));
	}
}