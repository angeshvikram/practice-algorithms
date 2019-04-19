package String;

public class IsomorphicString {
	/*
	 * Check if two given strings are isomorphic to each other Two strings str1 and
	 * str2 are called isomorphic if there is a one to one mapping possible for
	 * every character of str1 to every character of str2. And all occurrences of
	 * every character in ‘str1’ map to same character in ‘str2’
	 * 
	 * Examples:
	 * 
	 * Input: str1 = "aab", str2 = "xxy" 
	 * Output: True 
	 * 'a' is mapped to 'x' and 'b' is mapped to 'y'.
	 * 
	 * Input: str1 = "aab", str2 = "xyz" 
	 * Output: False 
	 * One occurrence of 'a' in str1 has 'x' in str2 and other occurrence of 'a' has 'y'.
	 * 
	 */
	
	public static int getCharDiff(char _first,char _second) {
		
		//if(_first - _second)
		
		return 1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 65; i <  91; i++) {
			System.out.println(Character.toString ((char) i));			
		}
		
		System.out.println("-------------------");
		getCharDiff('A','Z');
	}

}
