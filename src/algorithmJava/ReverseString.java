package algorithmJava;

public class ReverseString {
	public String reverseByStringWord(String _str) {
		System.out.println("Reversing string :"+_str);
		
		String []strArr = _str.split(" ");
		
		String revStr = "";
		for(int i = (strArr.length-1); i >= 0;i--) {
			revStr =  revStr + " " + strArr[i];
		}
		return revStr.trim();
	}

	public String reverseStringByChar(String _str) {
		System.out.println("Reversing string :"+_str);
		
		//String []strArr = _str.split(" ");
		
		String revStr = "";
		for(int i = (_str.length()-1); i >= 0;i--) {
			revStr =  revStr + _str.charAt(i);
		}
		return revStr;
	}	
}
