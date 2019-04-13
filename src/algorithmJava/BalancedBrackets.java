package algorithmJava;

import java.util.Stack;

public class BalancedBrackets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(checkForBalancedBrackets("Hello [ this is ( check for ) checkForBalancedBrackets]."));

	}
	
	public static boolean checkForBalancedBrackets(String _str) {
				
		Stack <Character> tempStack = new Stack<Character>();
		
		for (int iStart = 0; iStart < _str.length();iStart++) {
			if((_str.charAt(iStart) == '[') || (_str.charAt(iStart) == '(') || (_str.charAt(iStart) == '{')) {
				tempStack.push(_str.charAt(iStart));
			} else if (_str.charAt(iStart) == ']') {
				if(tempStack.empty() || tempStack.pop() != '[') {
					return false;
				}
			} else if (_str.charAt(iStart) == ')') {
				if(tempStack.empty() || tempStack.pop() != '(') {
					return false;
				}
			} else if (_str.charAt(iStart) == '}') {
				if(tempStack.empty() || tempStack.pop() != '{') {
					return false;
				}
			}
			
		}
		
		
		return tempStack.isEmpty();
	}

}
